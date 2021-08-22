# Exercise 2

### 1. Task 1
```
join(): phương thức này sẽ thông báo thread này hoàn thành rồi thread cha mới được tiếp tục chạy
```

### 2. Task 2
```
- Hệ điều hành đa nhiệm sẽ phân phối CPU cho các tiến trình, các luồng theo vòng xoay. 
- Mỗi luồng sẽ được cấp CPU trong 1 khoảng thời gian nhất định, sau đó trả lại CPU cho hệ điều hành (HĐH), HĐH sẽ cấp CPU cho luồng khác.
- Các luồng sẽ nằm chờ trong hàng đợi Ready để nhận CPU theo thứ tự.

yield(): khi gọi phương thức này luồng sẽ bị ngừng cấp CPU và nhường cho luồng tiếp theo trong hàng chờ Ready. Luồng không phải ngưng cấp CPU như suspend mà chỉ ngưng cấp trong lần nhận CPU đó mà thôi.
```

### 3. Task 3
```
setDaemon(boolean): xác định thread là một luồng Daemon hay không.
```

### 4. Task 4
#### 4.1: Task A
```
    
```

#### 4.1: Task B
```

```