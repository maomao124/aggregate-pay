import request from '@/utils/request'
import { UserModule } from '@/store/modules/user'


//支付渠道查询
export const channelList = () =>
  request({
    url: `/operation/m/paychannels/list?tenantId=${UserModule.tenantId}`,
    method: 'get'
  })