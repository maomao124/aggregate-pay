import { isValidUserName, isExternal } from '@/utils/validate'

describe('Utils:validate', () => {
  it('isValidUserName', () => {
    expect(isValidUserName('admin')).toBe(true)
    expect(isValidUserName('editor')).toBe(true)
    expect(isValidUserName('xxxx')).toBe(false)
  })

  it('isExternal', () => {
    expect(isExternal('https://www.armour.com/')).toBe(true)
    expect(isExternal('mailto:someone@test.com')).toBe(true)
    expect(isExternal('123aBC')).toBe(false)
  })
})
