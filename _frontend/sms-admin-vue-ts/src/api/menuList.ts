export const menuList = () => {
  return Promise.resolve([
    {
      path: '/',
      childMenuInfos: [],
      component: '/Index',
      isRoute: "0",
      icon: "icon-shouye",
      menuId: 233,
      parentId: 233,
      menuName: "首页",
      menuUrl: '/'
    },
    {
      childMenuInfos: [
        {
          childMenuInfos: [],
          component: "/messageService/SignManage",
          isRoute: "1",
          menuId: 261,
          menuName: "签名管理",
          menuUrl: "/messageService/SignManage",
          parentId: 261
        },
        {
          childMenuInfos: [],
          component: "/messageService/TemplateManage",
          isRoute: "1",
          menuId: 252,
          menuName: "模板管理",
          menuUrl: "/messageService/TemplateManage",
          parentId: 245
        },
        {
          childMenuInfos: [],
          component: "/messageService/PassagewayManage",
          isRoute: "1",
          menuId: 253,
          menuName: "通道管理",
          menuUrl: "/messageService/PassagewayManage",
          parentId: 246
        },
        {
          childMenuInfos: [],
          component: "/messageService/ApplyManage",
          isRoute: "1",
          menuId: 24,
          menuName: "应用管理",
          menuUrl: "/messageService/ApplyManage",
          parentId: 247
        },
        {
          childMenuInfos: [],
          component: "/messageService/ServiceLog",
          isRoute: "1",
          menuId: 55,
          menuName: "服务日志",
          menuUrl: "/messageService/ServiceLog",
          parentId: 248
        }
        
      ],
      isRoute: "0",
      menuId: 245,
      menuName: "短信服务",
      menuUrl: "#",
      icon: "icon-duanxinfuwu",
      parentId: 0
    },
	/**
    {
      isRoute: "1",
      menuId: 246,
      component: "/marketSMS/MarketSMS",
      menuName: "营销短信",
      menuUrl: "/MarketSMS",
      icon: 'icon-yingxiao22x',
      parentId: 0
    },
	**/
    {
      childMenuInfos: [
        {
          childMenuInfos: [],
          component: "/businessStatist/SendingNum",
          icon: "",
          isRoute: "1",
          menuId: 256,
          menuName: "发送量统计",
          menuUrl: "/businessStatist/SendingNum",
          parentId: 247
        },
		/**
        {
          childMenuInfos: [],
          component: "/businessStatist/MarketSMSStatist",
          icon: "",
          isRoute: "1",
          menuId: 56,
          menuName: "营销短信统计",
          menuUrl: "/businessStatist/MarketSMSStatist",
          parentId: 47
        },
		**/
        {
          childMenuInfos: [],
          component: "/businessStatist/SendRecord",
          icon: "",
          isRoute: "1",
          menuId: 257,
          menuName: "发送记录",
          menuUrl: "/businessStatist/SendRecord",
          parentId: 247
        }
      ],
      isRoute: "0",
      menuId: 247,
      menuName: "业务统计",
      menuUrl: "#",
      icon: 'icon-yewutongji',
      parentId: 0
    },
    {
      childMenuInfos: [
        {
          childMenuInfos: [],
          component: "/systemManage/BlacklistManage",
          icon: "",
          isRoute: "1",
          menuId: 258,
          menuName: "黑名单管理",
          menuUrl: "/systemManage/BlacklistManage",
          parentId: 248
        },
        // {
        //   childMenuInfos: [],
        //   component: "/billing/customerManage/FlowManage",
        //   isRoute: "1",
        //   menuId: 259,
        //   menuName: "流量包",
        //   menuUrl: "/customerManage/FlowManage",
        //   parentId: 248
        // },
        // {
        //   childMenuInfos: [],
        //   component: "/billing/customerManage/Reconciliation",
        //   icon: "",
        //   isRoute: "1",
        //   menuId: 290,
        //   menuName: "平账管理",
        //   menuUrl: "/customerManage/Reconciliation",
        //   parentId: 248
        // }
      ],
      isRoute: "0",
      menuId: 248,
      menuName: "系统管理",
      menuUrl: "#",
      icon: 'icon-xitong',
      parentId: 0
    },
    // {
    //   childMenuInfos: [
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/dataReport/MonthAccount",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 260,
    //       menuName: "对账月报",
    //       menuUrl: "/dataReport/MonthAccount",
    //       parentId: 249
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/dataReport/costReport",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 292,
    //       menuName: "接口销售成本报表",
    //       menuUrl: "/dataReport/costReport",
    //       parentId: 249
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/dataReport/DailyReport",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 433,
    //       menuName: "日对账报告",
    //       menuUrl: "/dataReport/DailyReport",
    //       parentId: 249
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/dataReport/ConsumptionReport",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 539,
    //       menuName: "异常统计报表",
    //       menuUrl: "/dataReport/ConsumptionReport",
    //       parentId: 249
    //     }
    //   ],
    //   isRoute: "0",
    //   menuId: 249,
    //   menuName: "数据源统计报表",
    //   menuUrl: "#",
    //   parentId: 0
    // },
    // {
    //   childMenuInfos: [
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/customerReport/MonthAccount",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 261,
    //       menuName: "对账月报",
    //       menuUrl: "/customerReport/MonthAccount",
    //       parentId: 250
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/customerReport/incomeReport",
    //       isRoute: "1",
    //       menuId: 293,
    //       menuName: "客户销售收入报表",
    //       menuUrl: "/customerReport/incomeReport",
    //       parentId: 250
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/customerReport/DailyReport",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 432,
    //       menuName: "日对账报告",
    //       menuUrl: "/customerReport/DailyReport",
    //       parentId: 250
    //     },
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/customerReport/ConsumptionReport",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 525,
    //       menuName: "异常统计报表",
    //       menuUrl: "/customerReport/ConsumptionReport",
    //       parentId: 250
    //     }
    //   ],
    //   isRoute: "0",
    //   menuId: 250,
    //   menuName: "客户方统计报表",
    //   menuUrl: "#",
    //   parentId: 0
    // },
    // {
    //   childMenuInfos: [
    //     {
    //       childMenuInfos: [],
    //       component: "/billing/timingTaskManage/TaskConfiguration",
    //       icon: "",
    //       isRoute: "1",
    //       menuId: 263,
    //       menuName: "任务配置",
    //       menuUrl: "/timingTaskManage/TaskConfiguration",
    //       parentId: 262,
    //     },
    //   ],
    //   isRoute: "0",
    //   menuId: 262,
    //   menuName: "定时任务管理",
    //   menuUrl: "#",
    //   parentId: 0
    // }
  ])
}
