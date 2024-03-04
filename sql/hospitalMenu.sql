-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院', '2000', '1', 'hospital', 'health/hospital/index', 1, 0, 'C', '0', '0', 'health:hospital:list', '#', 'admin', sysdate(), '', null, '医院菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'health:hospital:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'health:hospital:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'health:hospital:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'health:hospital:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('医院导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'health:hospital:export',       '#', 'admin', sysdate(), '', null, '');