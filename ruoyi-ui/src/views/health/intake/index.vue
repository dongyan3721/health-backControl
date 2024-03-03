<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="摄入项目" prop="inTakeCaseName">
        <el-input
          v-model="queryParams.inTakeCaseName"
          placeholder="请输入摄入项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['health:intake:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['health:intake:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['health:intake:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['health:intake:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="intakeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="UUID" align="center" prop="id" v-if="false"/>
      <el-table-column label="摄入项目" align="center" prop="inTakeCaseName" />
      <el-table-column label="建议摄入最小值" align="center" prop="recommendedLowerLimit" />
      <el-table-column label="建议摄入最大值" align="center" prop="recommendedUpperLimit" />
      <el-table-column label="计量单位" align="center" prop="metric" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['health:intake:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['health:intake:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改intake对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="摄入项目" prop="inTakeCaseName">
          <el-input v-model="form.inTakeCaseName" placeholder="请输入摄入项目" />
        </el-form-item>
        <el-form-item label="建议摄入最小值" prop="recommendedLowerLimit">
          <el-input v-model="form.recommendedLowerLimit" placeholder="请输入建议摄入最小值" />
        </el-form-item>
        <el-form-item label="建议摄入最大值" prop="recommendedUpperLimit">
          <el-input v-model="form.recommendedUpperLimit" placeholder="请输入建议摄入最大值" />
        </el-form-item>
        <el-form-item label="计量单位" prop="metric">
          <el-input v-model="form.metric" placeholder="请输入计量单位" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listIntake, getIntake, delIntake, addIntake, updateIntake } from "@/api/health/intake";

export default {
  name: "Intake",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // intake表格数据
      intakeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inTakeCaseName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inTakeCaseName: [
          { required: true, message: "摄入项目不能为空", trigger: "blur" }
        ],
        recommendedLowerLimit: [
          { required: true, message: "建议摄入最小值不能为空", trigger: "blur" }
        ],
        recommendedUpperLimit: [
          { required: true, message: "建议摄入最大值不能为空", trigger: "blur" }
        ],
        metric: [
          { required: true, message: "计量单位不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询intake列表 */
    getList() {
      this.loading = true;
      listIntake(this.queryParams).then(response => {
        this.intakeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        delFlag: null,
        createBy: null,
        createTime: null,
        modifyBy: null,
        modifyTime: null,
        remark: null,
        id: null,
        inTakeCaseName: null,
        recommendedLowerLimit: null,
        recommendedUpperLimit: null,
        metric: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加intake";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getIntake(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改intake";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateIntake(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIntake(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除intake编号为"' + ids + '"的数据项？').then(function() {
        return delIntake(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('health/intake/export', {
        ...this.queryParams
      }, `intake_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
