
export const formatDate = () => {
  const now = new Date()
  let hour: string | number = now.getHours()
  let minute: string | number = now.getMinutes()
  let second: string | number = now.getSeconds()
  if (hour < 10) hour = `0${hour}`
  if (minute < 10) minute = `0${minute}`
  if (second < 10) second = `0${second}`
  return `${hour}:${minute}:${second}`
}

// 获取当天
export const formatTodayDate = () => {
  // const _date = Number(str)
  const now = new Date()
  const year = now.getFullYear()
  let month: string | number = now.getMonth() + 1
  let date: string | number = now.getDate()
  if (month < 10) month = `0${month}`
  if (date < 10) date = `0${date}`
  // let hour: string | number = now.getHours()
  // let minute: string | number = now.getMinutes()
  // let second: string | number = now.getSeconds()
  // if (hour < 10) hour = `0${hour}`
  // if (minute < 10) minute = `0${minute}`
  // if (second < 10) second = `0${second}`
  return `${year}-${month}-${date}`
}

// 获取上个月day
export const getEndDay = () => {
  // 构造当前日期对象
  const date = new Date()
  const year = date.getFullYear()
  //获取当前月份
  const mouth = date.getMonth()
  let days = 0
  if (mouth === 2) {
    days = year % 4 === 0 ? 29: 28
  } else if(mouth === 1 || mouth === 3 || mouth === 5 || mouth === 7 ||mouth === 8 ||mouth === 8 ||mouth === 12){
    days = 31
  } else {
    days = 30
  }
  return days
}

function dateFormat(fmt: any, date: any) {
  let ret
  const opt = {
    // 年
    'Y+': date.getFullYear().toString(),  
    // 月
    'm+': (date.getMonth() + 1).toString(),  
    // 日
    'd+': date.getDate().toString(),
    // 时  
    'H+': date.getHours().toString(),
    // 分   
    'M+': date.getMinutes().toString(),
    // 秒  
    'S+': date.getSeconds().toString()
    // 有其他格式化字符需求可以继续添加，必须转化成字符串
  } as any
  for ( const k in opt ) {
    ret = new RegExp('(' + k + ')').exec(fmt)
    if (ret) {
      fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, '0')))
    }
  }
  return fmt
}

// js获取从本月1号到今天的日期
export const get1stAndToday = () => {
  const TimeNow = new Date()
  // 当月1号
  let startDay1 = new Date(TimeNow.getFullYear(), TimeNow.getMonth(), 1)
  // 23:59:59 将结束时间改成前一天
  let endDay1 = new Date(TimeNow.getFullYear(), TimeNow.getMonth(), TimeNow.getDate(), 23, 59, 59)
  startDay1 = dateFormat('YYYY-mm-dd HH:MM:SS', startDay1)
  endDay1 = dateFormat('YYYY-mm-dd HH:MM:SS', endDay1)
  return [startDay1, endDay1]
}

// 获取本月1号
export const monthOneDay = () => {
  const TimeNow = new Date()
  // 当月1号
  let startDay1 = new Date(TimeNow.getFullYear(), TimeNow.getMonth(), 1)
  // 23:59:59 将结束时间改成前一天
  // startDay1 = dateFormat('YYYY-mm-dd HH:MM:SS', startDay1)
  startDay1 = dateFormat('YYYY-mm-dd', startDay1)
  return startDay1
}

//获得某月的天数
function getMonthDays(myMonth: any) {
  const now = new Date()
  const nowYear = now.getFullYear()
  const monthStartDate = Number(new Date(nowYear, myMonth, 1))
  const monthEndDate = Number(new Date(nowYear, myMonth + 1, 1))
  const days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24)
  return days
}

export const getLastMonthStartDateAndEndDate = () => {
  //当前日期
  const now = new Date()
  //今天本周的第几天
  const nowDayOfWeek = now.getDay()
  //当前日
  const nowDay = now.getDate()
  //当前月
  const nowMonth = now.getMonth()
  //当前年
  let nowYear = now.getFullYear()
  nowYear += (nowYear < 2000) ? 1900 : 0
  //上月日期
  const lastMonthDate = new Date()
  lastMonthDate.setDate(1)
  lastMonthDate.setMonth(lastMonthDate.getMonth() - 1)
  const lastYear = lastMonthDate.getFullYear()
  const lastMonth = lastMonthDate.getMonth()
  const lastMonthStartDate = new Date(nowYear, lastMonth, 1)
  const lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth))
  return [dateFormat('YYYY-mm-dd HH:MM:SS', lastMonthStartDate), dateFormat('YYYY-mm-dd HH:MM:SS', lastMonthEndDate)]
}


// 当前月份的最后一天
export const getCurrentMonthLast = () => {
  const date = new Date()
  let currentMonth = date.getMonth()
  const nextMonth = ++currentMonth
  const nextMonthFirstDay = Number(new Date(date.getFullYear(), nextMonth, 1))
  const oneDay = 1000 * 60 * 60 * 24
  const lastTime = new Date(nextMonthFirstDay - oneDay)
  let month: string | number = lastTime.getMonth() + 1
  let day: string | number = lastTime.getDate()
  if (month < 10) month = `0${month}`
  if (day < 10) day = `0${day}`
  // let hour: string | number = lastTime.getHours()
  // let minute: string | number = lastTime.getMinutes()
  // let second: string | number = lastTime.getSeconds()
  // if (hour < 10) hour = `0${hour}`
  // if (minute < 10) minute = `0${minute}`
  // if (second < 10) second = `0${second}`
  // return `${year}-${month}-${date} ${hour}:${minute}:${second}`
  return date.getFullYear() + '-' + month + '-' + day
}