package mao.aggregate_pay_user_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import mao.aggregate_pay_user_api.dto.tenant.AccountQueryDTO;
import mao.aggregate_pay_user_api.dto.tenant.AuthenticationInfo;
import mao.aggregate_pay_user_api.dto.tenant.BundleDTO;
import mao.aggregate_pay_user_api.dto.tenant.ChangeAccountPwdDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateAccountRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.CreateTenantRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantQueryDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TenantControllerV2Test
{
    /**
     * Method under test: {@link TenantControllerV2#createTenantAndInit(CreateTenantRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTenantAndInit()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createTenantAndInit(TenantControllerV2.java:57)
        //   In order to prevent createTenantAndInit(CreateTenantRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTenantAndInit(CreateTenantRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        tenantControllerV2.createTenantAndInit(createTenantRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createTenantAndInit(CreateTenantRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTenantAndInit2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createTenantAndInit(TenantControllerV2.java:57)
        //   In order to prevent createTenantAndInit(CreateTenantRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTenantAndInit(CreateTenantRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        CreateTenantRequestDTO createTenantRequestDTO = mock(CreateTenantRequestDTO.class);
        doNothing().when(createTenantRequestDTO).setBundleCode((String) any());
        doNothing().when(createTenantRequestDTO).setMobile((String) any());
        doNothing().when(createTenantRequestDTO).setName((String) any());
        doNothing().when(createTenantRequestDTO).setPassword((String) any());
        doNothing().when(createTenantRequestDTO).setTenantTypeCode((String) any());
        doNothing().when(createTenantRequestDTO).setUsername((String) any());
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        tenantControllerV2.createTenantAndInit(createTenantRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createTenantRelateAccount(CreateTenantRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTenantRelateAccount()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createTenantRelateAccount(TenantControllerV2.java:73)
        //   In order to prevent createTenantRelateAccount(CreateTenantRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTenantRelateAccount(CreateTenantRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        tenantControllerV2.createTenantRelateAccount(createTenantRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createTenantRelateAccount(CreateTenantRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTenantRelateAccount2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createTenantRelateAccount(TenantControllerV2.java:73)
        //   In order to prevent createTenantRelateAccount(CreateTenantRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTenantRelateAccount(CreateTenantRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        CreateTenantRequestDTO createTenantRequestDTO = mock(CreateTenantRequestDTO.class);
        doNothing().when(createTenantRequestDTO).setBundleCode((String) any());
        doNothing().when(createTenantRequestDTO).setMobile((String) any());
        doNothing().when(createTenantRequestDTO).setName((String) any());
        doNothing().when(createTenantRequestDTO).setPassword((String) any());
        doNothing().when(createTenantRequestDTO).setTenantTypeCode((String) any());
        doNothing().when(createTenantRequestDTO).setUsername((String) any());
        createTenantRequestDTO.setBundleCode("Bundle Code");
        createTenantRequestDTO.setMobile("Mobile");
        createTenantRequestDTO.setName("Name");
        createTenantRequestDTO.setPassword("iloveyou");
        createTenantRequestDTO.setTenantTypeCode("Tenant Type Code");
        createTenantRequestDTO.setUsername("janedoe");
        tenantControllerV2.createTenantRelateAccount(createTenantRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#getTenant(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTenant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.getTenant(TenantControllerV2.java:91)
        //   In order to prevent getTenant(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getTenant(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).getTenant(123L);
    }

    /**
     * Method under test: {@link TenantControllerV2#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryTenants()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryTenants(TenantControllerV2.java:119)
        //   In order to prevent queryTenants(TenantQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryTenants(TenantQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        TenantQueryDTO tenantQueryDTO = new TenantQueryDTO();
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.queryTenants(tenantQueryDTO, 1, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryTenants(TenantQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryTenants2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryTenants(TenantControllerV2.java:119)
        //   In order to prevent queryTenants(TenantQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryTenants(TenantQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        TenantQueryDTO tenantQueryDTO = mock(TenantQueryDTO.class);
        doNothing().when(tenantQueryDTO).setName((String) any());
        doNothing().when(tenantQueryDTO).setTenantTypeCode((String) any());
        tenantQueryDTO.setName("Name");
        tenantQueryDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.queryTenants(tenantQueryDTO, 1, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryBundleByTenantType(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryBundleByTenantType()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryBundleByTenantType(TenantControllerV2.java:134)
        //   In order to prevent queryBundleByTenantType(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryBundleByTenantType(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).queryBundleByTenantType("Tenant Type");
    }

    /**
     * Method under test: {@link TenantControllerV2#getBundle(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.getBundle(TenantControllerV2.java:152)
        //   In order to prevent getBundle(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getBundle(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).getBundle("Bundle Code");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryAllBundle()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAllBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryAllBundle(TenantControllerV2.java:165)
        //   In order to prevent queryAllBundle()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAllBundle().
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).queryAllBundle();
    }

    /**
     * Method under test: {@link TenantControllerV2#changeBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.changeBundle(TenantControllerV2.java:184)
        //   In order to prevent changeBundle(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).changeBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantControllerV2#initBundle(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInitBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.initBundle(TenantControllerV2.java:204)
        //   In order to prevent initBundle(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   initBundle(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).initBundle(123L, "Bundle Code");
    }

    /**
     * Method under test: {@link TenantControllerV2#createBundle(BundleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createBundle(TenantControllerV2.java:219)
        //   In order to prevent createBundle(BundleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createBundle(BundleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        BundleDTO bundleDTO = new BundleDTO();
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.createBundle(bundleDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createBundle(BundleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateBundle2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createBundle(TenantControllerV2.java:219)
        //   In order to prevent createBundle(BundleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createBundle(BundleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        BundleDTO bundleDTO = mock(BundleDTO.class);
        doNothing().when(bundleDTO).setAbility((String) any());
        doNothing().when(bundleDTO).setCode((String) any());
        doNothing().when(bundleDTO).setComment((String) any());
        doNothing().when(bundleDTO).setId((Long) any());
        doNothing().when(bundleDTO).setInitialize((Boolean) any());
        doNothing().when(bundleDTO).setName((String) any());
        doNothing().when(bundleDTO).setNumberOfApp((Integer) any());
        doNothing().when(bundleDTO).setNumberOfConcurrent((Integer) any());
        doNothing().when(bundleDTO).setNumberOfInvocation((Integer) any());
        doNothing().when(bundleDTO).setTenantTypeCode((String) any());
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.createBundle(bundleDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#modifyBundle(BundleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyBundle()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.modifyBundle(TenantControllerV2.java:234)
        //   In order to prevent modifyBundle(BundleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyBundle(BundleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        BundleDTO bundleDTO = new BundleDTO();
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.modifyBundle(bundleDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#modifyBundle(BundleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testModifyBundle2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.modifyBundle(TenantControllerV2.java:234)
        //   In order to prevent modifyBundle(BundleDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   modifyBundle(BundleDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        BundleDTO bundleDTO = mock(BundleDTO.class);
        doNothing().when(bundleDTO).setAbility((String) any());
        doNothing().when(bundleDTO).setCode((String) any());
        doNothing().when(bundleDTO).setComment((String) any());
        doNothing().when(bundleDTO).setId((Long) any());
        doNothing().when(bundleDTO).setInitialize((Boolean) any());
        doNothing().when(bundleDTO).setName((String) any());
        doNothing().when(bundleDTO).setNumberOfApp((Integer) any());
        doNothing().when(bundleDTO).setNumberOfConcurrent((Integer) any());
        doNothing().when(bundleDTO).setNumberOfInvocation((Integer) any());
        doNothing().when(bundleDTO).setTenantTypeCode((String) any());
        bundleDTO.setAbility("Ability");
        bundleDTO.setCode("Code");
        bundleDTO.setComment("Comment");
        bundleDTO.setId(123L);
        bundleDTO.setInitialize(true);
        bundleDTO.setName("Name");
        bundleDTO.setNumberOfApp(10);
        bundleDTO.setNumberOfConcurrent(10);
        bundleDTO.setNumberOfInvocation(10);
        bundleDTO.setTenantTypeCode("Tenant Type Code");
        tenantControllerV2.modifyBundle(bundleDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccount(ChangeAccountPwdDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccount(TenantControllerV2.java:268)
        //   In order to prevent createAccount(ChangeAccountPwdDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(ChangeAccountPwdDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        ChangeAccountPwdDTO changeAccountPwdDTO = new ChangeAccountPwdDTO();
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        tenantControllerV2.createAccount(changeAccountPwdDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccount(ChangeAccountPwdDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccount(TenantControllerV2.java:268)
        //   In order to prevent createAccount(ChangeAccountPwdDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(ChangeAccountPwdDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        ChangeAccountPwdDTO changeAccountPwdDTO = mock(ChangeAccountPwdDTO.class);
        doNothing().when(changeAccountPwdDTO).setAccountId((Long) any());
        doNothing().when(changeAccountPwdDTO).setPassword((String) any());
        doNothing().when(changeAccountPwdDTO).setUserName((String) any());
        changeAccountPwdDTO.setAccountId(1234567890L);
        changeAccountPwdDTO.setPassword("iloveyou");
        changeAccountPwdDTO.setUserName("janedoe");
        tenantControllerV2.createAccount(changeAccountPwdDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccount(TenantControllerV2.java:253)
        //   In order to prevent createAccount(CreateAccountRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(CreateAccountRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        tenantControllerV2.createAccount(createAccountRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccount(CreateAccountRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccount(TenantControllerV2.java:253)
        //   In order to prevent createAccount(CreateAccountRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccount(CreateAccountRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        tenantControllerV2.createAccount(createAccountRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccountInTenant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccountInTenant(TenantControllerV2.java:287)
        //   In order to prevent createAccountInTenant(CreateAccountRequestDTO, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccountInTenant(CreateAccountRequestDTO, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        CreateAccountRequestDTO createAccountRequestDTO = new CreateAccountRequestDTO();
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        tenantControllerV2.createAccountInTenant(createAccountRequestDTO, 123L);
    }

    /**
     * Method under test: {@link TenantControllerV2#createAccountInTenant(CreateAccountRequestDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccountInTenant2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.createAccountInTenant(TenantControllerV2.java:287)
        //   In order to prevent createAccountInTenant(CreateAccountRequestDTO, Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createAccountInTenant(CreateAccountRequestDTO, Long).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        CreateAccountRequestDTO createAccountRequestDTO = mock(CreateAccountRequestDTO.class);
        doNothing().when(createAccountRequestDTO).setMobile((String) any());
        doNothing().when(createAccountRequestDTO).setPassword((String) any());
        doNothing().when(createAccountRequestDTO).setUsername((String) any());
        createAccountRequestDTO.setMobile("Mobile");
        createAccountRequestDTO.setPassword("iloveyou");
        createAccountRequestDTO.setUsername("janedoe");
        tenantControllerV2.createAccountInTenant(createAccountRequestDTO, 123L);
    }

    /**
     * Method under test: {@link TenantControllerV2#bindTenant(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBindTenant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.bindTenant(TenantControllerV2.java:307)
        //   In order to prevent bindTenant(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   bindTenant(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).bindTenant(123L, "janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#unbindTenant(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnbindTenant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.unbindTenant(TenantControllerV2.java:327)
        //   In order to prevent unbindTenant(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   unbindTenant(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).unbindTenant(123L, "janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#isExistAccountByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsExistAccountByUsername()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.isExistAccountByUsername(TenantControllerV2.java:343)
        //   In order to prevent isExistAccountByUsername(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isExistAccountByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).isExistAccountByUsername("janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#isExistAccountByMobile(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsExistAccountByMobile()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.isExistAccountByMobile(TenantControllerV2.java:359)
        //   In order to prevent isExistAccountByMobile(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isExistAccountByMobile(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).isExistAccountByMobile("Mobile");
    }

    /**
     * Method under test: {@link TenantControllerV2#getAccountByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAccountByUsername()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.getAccountByUsername(TenantControllerV2.java:374)
        //   In order to prevent getAccountByUsername(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAccountByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).getAccountByUsername("janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#getAccountByMobile(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAccountByMobile()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.getAccountByMobile(TenantControllerV2.java:389)
        //   In order to prevent getAccountByMobile(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAccountByMobile(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).getAccountByMobile("Mobile");
    }

    /**
     * Method under test: {@link TenantControllerV2#isExistAccountInTenantByUsername(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsExistAccountInTenantByUsername()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.isExistAccountInTenantByUsername(TenantControllerV2.java:409)
        //   In order to prevent isExistAccountInTenantByUsername(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isExistAccountInTenantByUsername(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).isExistAccountInTenantByUsername(123L, "janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#isExistAccountInTenantByMobile(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsExistAccountInTenantByMobile()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.isExistAccountInTenantByMobile(TenantControllerV2.java:429)
        //   In order to prevent isExistAccountInTenantByMobile(Long, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   isExistAccountInTenantByMobile(Long, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).isExistAccountInTenantByMobile(123L, "Mobile");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAccount()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryAccount(TenantControllerV2.java:456)
        //   In order to prevent queryAccount(AccountQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAccount(AccountQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        AccountQueryDTO accountQueryDTO = new AccountQueryDTO();
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        tenantControllerV2.queryAccount(accountQueryDTO, 3, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryAccount(AccountQueryDTO, Integer, Integer, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAccount2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryAccount(TenantControllerV2.java:456)
        //   In order to prevent queryAccount(AccountQueryDTO, Integer, Integer, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAccount(AccountQueryDTO, Integer, Integer, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        AccountQueryDTO accountQueryDTO = mock(AccountQueryDTO.class);
        doNothing().when(accountQueryDTO).setMobile((String) any());
        doNothing().when(accountQueryDTO).setTenantId((Long) any());
        doNothing().when(accountQueryDTO).setUsername((String) any());
        accountQueryDTO.setMobile("Mobile");
        accountQueryDTO.setTenantId(123L);
        accountQueryDTO.setUsername("janedoe");
        tenantControllerV2.queryAccount(accountQueryDTO, 3, 3, "Sort By", "Order");
    }

    /**
     * Method under test: {@link TenantControllerV2#queryAccountInTenant(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryAccountInTenant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.queryAccountInTenant(TenantControllerV2.java:471)
        //   In order to prevent queryAccountInTenant(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryAccountInTenant(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).queryAccountInTenant("janedoe");
    }

    /**
     * Method under test: {@link TenantControllerV2#sendMessage(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMessage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.sendMessage(TenantControllerV2.java:486)
        //   In order to prevent sendMessage(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendMessage(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).sendMessage("4105551212");
    }

    /**
     * Method under test: {@link TenantControllerV2#authentication(AuthenticationInfo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthentication()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.authentication(TenantControllerV2.java:501)
        //   In order to prevent authentication(AuthenticationInfo)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authentication(AuthenticationInfo).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        AuthenticationInfo authenticationInfo = new AuthenticationInfo();
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        tenantControllerV2.authentication(authenticationInfo);
    }

    /**
     * Method under test: {@link TenantControllerV2#authentication(AuthenticationInfo)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAuthentication2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.authentication(TenantControllerV2.java:501)
        //   In order to prevent authentication(AuthenticationInfo)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   authentication(AuthenticationInfo).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        AuthenticationInfo authenticationInfo = mock(AuthenticationInfo.class);
        doNothing().when(authenticationInfo).setAuthenticationType((String) any());
        doNothing().when(authenticationInfo).setCertificate((String) any());
        doNothing().when(authenticationInfo).setPrincipal((String) any());
        doNothing().when(authenticationInfo).setSmsKey((String) any());
        authenticationInfo.setAuthenticationType("Authentication Type");
        authenticationInfo.setCertificate("Certificate");
        authenticationInfo.setPrincipal("Principal");
        authenticationInfo.setSmsKey("Sms Key");
        tenantControllerV2.authentication(authenticationInfo);
    }

    /**
     * Method under test: {@link TenantControllerV2#login(LoginRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.login(TenantControllerV2.java:516)
        //   In order to prevent login(LoginRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   login(LoginRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setAuthenticationType("Authentication Type");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        tenantControllerV2.login(loginRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#login(LoginRequestDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.login(TenantControllerV2.java:516)
        //   In order to prevent login(LoginRequestDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   login(LoginRequestDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        TenantControllerV2 tenantControllerV2 = new TenantControllerV2();
        LoginRequestDTO loginRequestDTO = mock(LoginRequestDTO.class);
        doNothing().when(loginRequestDTO).setAuthenticationType((String) any());
        doNothing().when(loginRequestDTO).setCertificate((String) any());
        doNothing().when(loginRequestDTO).setPrincipal((String) any());
        doNothing().when(loginRequestDTO).setSmsKey((String) any());
        loginRequestDTO.setAuthenticationType("Authentication Type");
        loginRequestDTO.setCertificate("Certificate");
        loginRequestDTO.setPrincipal("Principal");
        loginRequestDTO.setSmsKey("Sms Key");
        tenantControllerV2.login(loginRequestDTO);
    }

    /**
     * Method under test: {@link TenantControllerV2#getApplicationDTOByClientId(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetApplicationDTOByClientId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.controller.TenantControllerV2.getApplicationDTOByClientId(TenantControllerV2.java:531)
        //   In order to prevent getApplicationDTOByClientId(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getApplicationDTOByClientId(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new TenantControllerV2()).getApplicationDTOByClientId("42");
    }
}

