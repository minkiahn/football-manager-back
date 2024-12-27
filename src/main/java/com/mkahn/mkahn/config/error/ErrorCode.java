package com.mkahn.mkahn.config.error;

public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(false,400,"L-90000", "잘못된 파라메터 값"),
    INVALID_INPUT_NAME(false,400,"L-90010", "잘못된 파라메터 이름"),
    INVALID_INPUT_TYPE(false,400, "L-90020", "잘못된 파라메터 타입"),

    //GIVITA
    ALREADY_ATHN_NO(true, 200, "L-10215", "이미 등록된 회원 코드입니다"),
    SNS_NETWORK_ERROR(true, 200, "L-10220", "소셜 로그인 통신이 불안정합니다."),
    EMAIL_DUPLICATION(true,200,"L-10130", "중복된 이메일 입니다."),
    ATHN_NO_NOT_FOUND(true,200, "L-10090", "회원코드를 다시 확인해주세요"),
    LEAVE_USER_ERROR(true, 200, "L-10240","사용할 수 없는 계정입니다\n계정과 관련해 문의사항이 있으면\n1661 - 3489로 연락주세요"),
    LOGIN_FAIL_ERROR(true, 200, "L-10250","회원 정보와 일치하지 않아요"),
    INVAILD_ATHN_NO(true, 200, "L-10260","미션 코드를 다시 한 번 확인해 주세요"),
    ATHN_NO_UPDATE_ERROR(true, 200, "L-10270","미션코드 입력시 오류가 발생 하였습니다. 잠시후 다시 시도해 주세요"),
    SIGNUP_ERROR(true, 200, "L-10280","회원가입시 오류가 발생 하였습니다. 잠시후 다시 시도해 주세요(추천인 코드 생성 오류)"),
    INVAILD_RECMD_CD(true, 200, "L-10290","등록되지 않은 추천 코드 입니다."),
    END_RECMD_CD(true, 200, "L-10300","종료된 추천 코드 입니다."),
    /********************************************************************
    로직에러_START
     **********************************************************************/
    //사용자미션
    CANNOT_MISSION_START_STATUS(true, 200, "L-20000", "미션이 시작 할 수 있는 상태가 아닙니다."),
    CANNOT_MISSION_START_LIMIT(true, 200, "L-20001", "미션이 시작 제한 일수를 초과하였습니다."),
    MISSION_START_FAIL(true, 200, "L-20002", "미션 시작을 실패 하였습니다"),
    CANNOT_MISSION_START_YESTERDAY(true, 200, "L-20003", "과거 시간으로 미션을 시작 할 수 없습니다"),
    CANNOT_SEND_DATA(true, 200, "L-20004", "삼성헬스 정보 수집 동의를 하지 않아 데이터를 전송 할 수 없습니다."),
    NON_EXIST_ING_MISSION(true, 200, "L-20005", "진행중인 미션이 존재 하지 않습니다. "),
    USED_MISSION(true, 200, "L-20006", "이미 사용한 미션코드를 입력 하셨어요"),
    USING_MISSION(true, 200, "L-20006", "지금 진행중인 미션코드를 입력 하셨어요"),
    CANNOT_CHANGE_STEP_GOAL(true, 200, "L-20007", "미션이 진행중일때는 걸음 목표수를 변경할 수 없어요"),

    //어슬렁가이드
    FAIL_TO_UPLOAD_IMAGE(true,200,"L-30100", "이미지 업로드에 실패하였습니다."),
    FAIL_TO_DELETE_IMAGE(true,200,"L-30200", "이미지 삭제에 실패하였습니다."),
    FAIL_TO_DELETE_SPOT(true,200,"L-30300", "흔적 삭제에 실패하였습니다."),
    FAIL_TO_INSERT_LIKE(true,200,"L-30400", "좋아요 등록에 실패하였습니다."),
    FAIL_TO_DELETE_LIKE(true,200,"L-30500", "좋아요 삭제에 실패하였습니다."),
    FAIL_TO_INSERT_REPORT(true,200,"L-30600", "신고 등록에 실패하였습니다."),

    //공통영역
    FAIL_GET_ATHN_NO(true, 200, "L-10000", "인증번호 획득에 실패 하였습니다`."),

    CANNOT_LOGOUT(true,200,"L-10220", "로그아웃할 수 없습니다."),
    FAIL_API_INVOICE(true,200,"L-10320", "송장번호 전송중 오류가 발생 하였습니다. "),
    FAIL_API_DELIVERY_ORDER(false,500,"L-10330", "shippingMasterNo(= %1) shopOrderId(= %2)\n\n상품 상태 변경 중 오류가 발생 하였습니다.\n\n"),
    FAIL_API_TOSS_PAYMENT_CANCEL(false,500,"L-10340", "shippingMasterNo(= %1) shopOrderId(= %2)\n\n토스 결제 취소 중 오류가 발생 하였습니다.\n\n"),
    FAIL_API_UN_SUPPORT_DELIVERY_ORDER(false,500,"L-10350", "shippingMasterNo(= %1) shopOrderId(= %2)\n\n지원 하지 않는 상품 상태 입니다.\n\n"),

    JWT_AUTH_ERROR(false,403,"L-10030", "액세스 권한이 없습니다. 다시 로그인하세요."),
    EXPIRED_TOKEN_ERROR(false,401,"L-10050", "액세스 토큰이 존재하지 않거나 유효기간이 지났습니다."),
    INTERNAL_SERVER_ERROR(false,500,"L-10080", "서버 에러! 관리자에게 문의하여주세요."),
    INTERNAL_SERVER_ANOTHER_ERROR(false,500,"L-10081", "서버 에러! 관리자에게 문의하여주세요.\n%1"),
    DUP_CHK_ERROR(true,200,"L-10190", "중복된 정보입니다(%1)"),
    FRBID_WORD_ERROR(true,200,"L-10100","비속어는 사용하실 수 없습니다"),
    INVALID_NICK_NM_ERROR(true,200,"L-10110","사용할 수 없는 닉네임입니다"),

    HANDLE_ACCESS_DENIED(false,403,"L-10040", "허가되지 않은 요청"),
    ROW_NOT_FOUND_ERROR(true,200,"L-10060", "해당 데이터가 없습니다.(%1)"),
    METHOD_NOT_ALLOWED(false,400,"L-10070", "잘못된 HTTP 메소드"),
    ENTITY_NOT_FOUND(true,200, "L-10090", "해당항목이 없습니다."),
    SQL_SYNTAX_ERROR(false,500, "L-10082", "SQL Syntax Error이 발생하였습니다."),
    DATE_PARSE_ERROR(false,500, "L-10083", "PARSE Error가 발생하였습니다. 관리자에게 문의하여주세요."),
    EMPTY_FILE_ERROR(true,200,"L-10110", "파일이 존재하지 않습니다."),
    NULL_FILE_ERROR(true,200,"L-10111", "파일의 내용이 존재하지 않습니다."),
    SAVE_FILE_ERROR( false,500,"L-10120", "파일이 저장중 에러가 났습니다."),
    EXCEL_FILE_NAME_NOT_EXIST( false,500,"L-10125", "엑셀 파일명이 존재하지 않습니다."),
    LOGIN_INPUT_INVALID(true,200,"L-10140", "로그인 정보가 유효하지 않습니다. 입력정보를 확인해주세요."),
    USER_NOT_FOUND(true,200,"L-10210", "해당 사용자 정보가 없습니다."),
    USER_NOT_FOUND_DORMANT(true, 200, "L-10211", "휴면 대상 사용자가 없습니다."),
    SELF_RECOMMEND(true, 200, "L-10216", "본인의 추천코드는 등록할 수 없습니다."),
    SIGNUPDT_NOT_FOUND(true,200,"L-10217", "해당 사용자의 가입일자 정보가 없습니다."),

    AUTH_NO_CHECK_ERROR(true, 200, "L-10230","인증번호가 일치하지 않습니다."),
    AUTH_NO_GENERATE_ERROR(true, 200, "L-10235","인증번호 생성에 실패했습니다."),
    NOT_MATCHED_PWD(true, 200, "L-10236", "기존 비밀번호가 일치하지 않습니다."),
    NOT_MATCHED_CI(true, 200, "L-10237", "일치 하는 CI값이 존재 하지 않습니다."),

    CHECK_SIGN_UP_DT_EVENT(true, 200, "L-20008", "이벤트 기간 이전 가입한 사용자입니다."),
    /********************************************************************
    로직에러_END
     **********************************************************************/


    /********************************************************************
    필수값_START
     **********************************************************************/

    REQUIRED_MISS(true, 400, "R-40000", "%1는 필수값입니다."),
    REQUIRED_MANDATORY(true,200,"R-20000", "%1은(는) 필수항목 입니다."),
    REQUIRED_FILE(true, 200, "R-20032", "업로드할 파일이 없습니다."),
    REQUIRED_USER_ID(true, 200, "R-20033", "userId 값이 누락되었습니다."),
    REQUIRED_TYPE(true, 200, "R-20038", "type값이 누락되었습니다."),
    REQUIRED_PWD(true, 200, "R-20040", "비밀번호는 필수항목 입니다."),
    REQUIRED_ATHN_NO(true, 200, "R-20050", "회원코드는 필수항목 입니다."),

    /********************************************************************
    필수값_END
     **********************************************************************/

    /********************************************************************
    데이터검증_START
    **********************************************************************/

    //미션타입
    NON_EXIST_MISSION_TYPE(true, 200, "D-10001", "정의 되지 않은 미션타입 입니다."),
    NON_EXIST_MISSION_NO(true, 200, "D-10002", "할당된 미션이 없는 회원코드 입니다."),

    //프로젝트
    CHECK_PJT_INFO(true, 200, "D-40000", "프로젝트 정보가 존재하지 않습니다."),
    CHECK_CD_DTL(true, 200, "D-40001", "잘못된 항목 코드이거나 사용이 중지된 항목 코드 입니다. "),

    //사용자 미션
    CHECK_USER_MISSION(true, 200, "D-20000", "사용자 미션 정보가 존재하지 않습니다."),
    CHECK_USER_DAILY_MISSION(true, 200, "D-20010", "사용자 데일리 미션 정보가 존재하지 않습니다."),
    CHECK_DAILY_MISSION(true, 200, "D-30001", "데일리 미션 정보가 존재하지 않습니다."),
    CHECK_USER_MISSION_MASTER(true, 200, "D-20000", "사용자 메인 미션 정보가 존재하지 않습니다."),
    NON_EXIST_MEASURE_DATA(true, 200, "D-20020", "사용자 측정 데이터가 존재하지 않습니다."),
    CHECK_COMP_NM(true, 200, "D-31000", "판매처 정보가 존재하지 않습니다(이름 : %1, 핸드펀 번호 : %2)"),
    CHECK_PRDT_CD(true, 200, "D-32000", "디바이스 정보가 존재하지 않습니다(이름 : %1, 핸드펀 번호 : %2)"),
    CHECK_DUPLICATION_USER_MISSION(true, 200, "D-33000", "이미 등록된 사용자 미션이 존재합니다."),

    //일반
    CHECK_SEARCH_DATE(true, 200, "D-50000", "검색 기간 설정이 잘못 되었습니다. "),
    CHECK_DATA(true, 200, "D-50001", "입력 정보가 정확 하지 않습니다."),
    NON_EXIST_RANK_TYPE(true, 200, "D-50010", "잘못된 랭크 타입 코드 입니다"),

    NON_EXIST_REPORT_RESULT(true, 200, "D-50011", "유전자 검사 결과가 없습니다."),

    INVALID_USER_ID_EXISTED(true, 200, "D-50012", "존재하지 않는 사용자 ID가 있습니다."),

    /********************************************************************
    데이터 검즏_END
    **********************************************************************/

    /**
     * 데이터 검증 에러(E)
     */

    NOT_MATCH_REWARD_INFO(true,200,"R-30050", "입력하신 정보와 일치하는 리워드가 없습니다."),
    NOT_EXIST_ROVING_COURSE(true,200,"R-30300", "산책 코스가 존재하지 않는 지역입니다."),
    WRONG_REGION_GU_CD(true,200,"R-30310", "입력된 지역코드에 대한 조회 결과가 존재하지 않습니다."),

    ALREADY_REGISTERED_ANSWER(true, 200, "R-30070", "이미 등록된 답변이 있습니다."),

    CHECK_RESV_DATE_FORMAT(false, 400, "E-20011", "%1은(는) 형식이 잘못되었습니다."),

    SAVE_ERROR(true,200,"R-30000", "%1이(가) 저장되지 않았습니다."),
    UPDATE_ERROR(true,200,"R-30010", "%1이(가) 수정되지 않았습니다."),
    DELETE_ERROR(true,200,"R-30020", "%1이(가) 삭제되지 않았습니다."),
    COMMON_ERROR(true,200,"R-30030","%1"),

    NOT_ENOUGH_POINTS(true,200,"R-30040","포인트가 부족합니다"),
    WRONG_VERNO(true,200,"R-30060","리워드 발급 처리중입니다."),


    //구독
    CHECK_CHANGE_DATE(false, 400, "E-20110", "변경 가능한 날짜가 아닙니다."),

    //메일발송실패
    SEND_MAIL_FAIL(true, 200, "L-10300", "메일발송에 실패했습니다."),

    //푸시메시지
    FAIL_TO_SAVE_PUSH_MESSAGE(true, 200, "E-10800", "푸시메시지를 저장하는데 실패하였습니다."),
    //ElasticSearch
    FAIL_TO_CONNECT_ELASTICSEARCH(true, 200, "E-10900", "ElasticSearch 연동에 실패하였습니다."),
    //Aligo API 연결 실패
    FAIL_TO_CONNECT_ALIGO(true, 200, "E-10700", "ALIGO API 연동에 실패하였습니다."),
    CHECK_TO_SENDLIST(true, 200, "E-10710", "kakaoTlak 알림발송 대상자가 존재하지 않습니다."),
    //GALAXIA
    FAIL_TO_CONNECT_GALAXIA(true, 200, "E-10600", "갤럭시아 머니트리 API와 통신 중 오류가 발생하였습니다."),
    FAIL_TO_POINT_PROCESS(true, 200, "E-10660", "상품권 교환 후 포인트 처리 중 오류가 발생하였습니다."),
    FAIL_TO_CANCEL_COUPON_GALAXIA(true, 200, "E-10640", "갤럭시아 상품권 발행 취소를 실패하였습니다.\n(%1)"),
    CHECK_TO_CANCEL_COUPON_GALAXIA(true, 200, "E-10650", "취소가 불가능한 상품권입니다."),

    //기상청 API 연결 실패
    FAIL_TO_CONNECT_KMA(true, 200, "E-11100", "기상청 API와 통신 중 오류가 발생하였습니다."),

    //사방넷 API 연결 실패
    FAIL_TO_CONNECT_SABANGNET(true, 200, "E-10610", "사방넷 API와 통신 중 오류가 발생하였습니다.\n%1"),
    //retrofit 통신 오류
    FAIL_TO_CONNECT_API(true, 200, "E-10620", "(외부 API와 통신 중 오류)"),
    FAIL_TO_PARSING_RESPONSE(true, 200, "E-10621", "응답값 PARSING 오류"),
    FAIL_TO_CONNECT_AI(true, 200, "E-10625", "AI 컨텐츠 불러오기실패"),
    //email 발송 오류
    FAIL_TO_SEND_EMAIL(true, 200, "E-10670", "이메일 발송 중 오류"),
    //firebase 오류
    FIREBASE_ERROR(true, 200, "E-10630", "FIREBASE 통신 오류"),

    UNMATCH_ROVING_CLASSIFICATE_CD(true, 200, "E-11000", "산책그룹분류코드에 따른 산책상세분류코드를 선택해주세요"),
    UNMATCH_ROVING_COURSE_NO(true, 200, "E-11010", "분류별 산책코스번호에 해당하는 코스번호가 존재하지 않습니다."),
    DUPLICATED_CLASSIFICATE_ROVING_COURSE_REGION(true, 200, "E-11011", "이미 추가한 분류별 산책코스 확장 지역입니다."),

    //이벤트 배송 관련
    USER_INFO_NOT_MATCH(false, 400, "L-10400", "이벤트 대상 회원이 아닙니다.\n수령인과 연락처를 다시 확인해주세요."),
    DELIVERY_INFO_ALREADY_EXIST(false, 400, "L-10401", "이미 참여한 이벤트입니다.");





    private final boolean result;
    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final boolean result, final int status, final String code, final String message) {
        this.result = result;
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public Boolean getResult() {return this.result;}

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
