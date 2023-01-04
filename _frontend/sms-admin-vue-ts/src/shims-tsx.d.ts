import Vue, { VNode } from 'vue'
import { Api } from '@/api'

declare global {
  namespace JSX {
    // tslint:disable no-empty-interface
    interface Element extends VNode {}
    // tslint:disable no-empty-interface
    interface ElementClass extends Vue {}
    interface IntrinsicElements {
      [elem: string]: any;
    }
  }
}


declare module 'vue/types/vue' {
  interface Vue {
    /** Used to show feedback after an activity. The difference with Notification is that the latter is often used to show a system level passive notification. */
    $api: Api;
  }
}
declare module 'vue-router/types/router' {
  interface Location {
    meta?: any;
  }
}

declare module 'axios' {
  interface AxiosRequestConfig {
    hideLoading?: () => void;
    showMsg?: boolean | string;
    errorMsg?: boolean | string;
  }
}

