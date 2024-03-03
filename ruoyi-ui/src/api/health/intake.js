import request from '@/utils/request'

// 查询intake列表
export function listIntake(query) {
  return request({
    url: '/health/intake/list',
    method: 'get',
    params: query
  })
}

// 查询intake详细
export function getIntake(id) {
  return request({
    url: '/health/intake/' + id,
    method: 'get'
  })
}

// 新增intake
export function addIntake(data) {
  return request({
    url: '/health/intake',
    method: 'post',
    data: data
  })
}

// 修改intake
export function updateIntake(data) {
  return request({
    url: '/health/intake',
    method: 'put',
    data: data
  })
}

// 删除intake
export function delIntake(id) {
  return request({
    url: '/health/intake/' + id,
    method: 'delete'
  })
}
