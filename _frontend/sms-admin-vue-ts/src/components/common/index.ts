// common文件夹全局注册
import { VueConstructor } from 'vue'
import Tabs from './Tabs.vue'
import UploadBtn from './UploadBtn.vue'
import ToastDialog from './ToastDialog.vue'
interface Comp {
	[key: string]: any;
}
const components = {
	Tabs,
	UploadBtn,
	ToastDialog
} as Comp

const install = (Vue: VueConstructor) => {
	if (install.installed) return
	Object.keys(components).forEach(component => {
		Vue.component(components[component].componentName, components[component])
	})
	install.installed = true
}

install.installed = false

if (typeof window !== "undefined" && window.Vue) {
	install(window.Vue)
	install.installed = true
}

const Vcomp = {
	...components,
	install
}

export default Vcomp