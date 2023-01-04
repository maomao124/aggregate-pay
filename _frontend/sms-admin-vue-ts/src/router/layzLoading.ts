export const formatMenus = (arr: any[]) => {
	return arr.map(function f (obj) {
		return {
			path: obj.menuUrl,
			component: obj.component,
			icon: obj.icon,
			title: obj.menuName,
			children: obj.childMenuInfos ? obj.childMenuInfos.map(f) : [],
			isRoute: obj.isRoute,
			id: obj.menuId
		}
	})
}

export const getRouters = (menu = [] as any, layzLoading: Function): any[] => {
	const routers: any[] = []
	menu.forEach(function getr (obj: any) {
		obj.meta = {
			title: obj.menuName | obj.title,
			id: obj.id
		}
		if (obj.component && Number(obj.isRoute) === 1) {
			obj.component = layzLoading(obj.component)
			routers.push(obj)
		}
		if (obj.children) obj.children.forEach(getr)
	})
	return routers
}

export const layzLoading = (path: string) => () => import(`@/pages/${path.replace(/^\/?/, '')}.vue`)