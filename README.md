# Test-MoMo
Bài test đầu vào momo

# Đề bài
Xem tài liệu trong docs: interview_Developer_assignment.docx.pdf

# Thông tin về ứng dụng
Có 3 loại service là:

    - ELECTRIC
    - WATER
    - INTERNET
Có 3 nhà cung cấp là:

    - EVN_HCMC
    - SAVACO_HCMC
    - VNPT

Ứng dụng cho phép những chức năng sau và cú pháp:

    Cashin:                     CASH_IN amount
    Create bill:                CREATE_BILL service amount due_date provider
    Update bill:                UPDATE_BILL bill_id service amount due_date provider
    Delete bill:                ELETE_BILL Bill_id
    View list bill:             LIST_BILL
    View list bill due date:    DUE_DATE
    Search by provider:         SEARCH_BILL_BY_PROVIDER provider
    Pay bill:                   PAY_BILL bill_id(n) bill_id(n+1) ...
    View payment list:          LIST_PAYMENT
    Schedule bill:              SCHEDULE Bill_id Date(format dd/MM/yyyy)
# Cách chạy ứng dụng

    B1: Dowload source
    B2: Chạy hàm main của class Main
    B3: Chạy các lệnh theo cú pháp ở trên
