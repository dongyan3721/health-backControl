import request from '@/utils/request'

// 查询静态键值对列表
export function listKv(query) {
  return request({
    url: '/health/kv/list',
    method: 'get',
    params: query
  })
}

// 查询静态键值对详细
export function getKv(id) {
  return request({
    url: '/health/kv/' + id,
    method: 'get'
  })
}

// 新增静态键值对
export function addKv(data) {
  return request({
    url: '/health/kv',
    method: 'post',
    data: data
  })
}

// 修改静态键值对
export function updateKv(data) {
  return request({
    url: '/health/kv',
    method: 'put',
    data: data
  })
}

// 删除静态键值对
export function delKv(id) {
  return request({
    url: '/health/kv/' + id,
    method: 'delete'
  })
}
