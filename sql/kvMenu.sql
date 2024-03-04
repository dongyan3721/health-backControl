-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对', '2000', '1', 'kv', 'health/kv/index', 1, 0, 'C', '0', '0', 'health:kv:list', '#', 'admin', sysdate(), '', null, '静态键值对菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'health:kv:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'health:kv:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'health:kv:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'health:kv:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('静态键值对导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'health:kv:export',       '#', 'admin', sysdate(), '', null, '');