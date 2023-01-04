export const mainMenu = [
	{
		path: '/',
		component: () => import('@/pages/Main.vue'),
		children: [
			{
				path: '/',
				component: () => import('@/pages/Index.vue'),
				meta: {
					title: '概况',
					id: '概况'
				}
			},
			// 历史记录
			{
				path: '/messageService/ChannelDeploy',
				component: () => import('@/pages/messageService/ChannelDeploy.vue'),
				meta: {
					title: '历史记录',
					id: '历史记录'
				}
			}
		]
	},
	{
		path: '*', redirect: '/404'
	}
]

