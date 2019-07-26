## 리눅스 HDD

##### IDE 

- 일반적으로 PC에서 사용되는 장치(4개 까지 낄 수 있다.)

- 최근에는 SATA

##### SCSI

- 서버에서 많이 사용 하는 장치 (16개가 제공)

- 최근에는 SA-SCSI 65.535개까지 연결 할 수 있다.

- 하드 디스크 확인

  

```
 ls /dev/sd*
/dev/sda  /dev/sda1  /dev/sda2  /dev/sdb
[root@server1 ~]# ls -l /dev/sd*
brw-rw---- 1 root disk 8,  0  7월 26  2019 /dev/sda
brw-rw---- 1 root disk 8,  1  7월 26  2019 /dev/sda1
brw-rw---- 1 root disk 8,  2  7월 26  2019 /dev/sda2
brw-rw---- 1 root disk 8, 16  7월 26  2019 /dev/sdb

```

> sda는 물리 적인 장치이고 이걸 파티션으로 나누면 -> sda1은 swap, sda2는 root , sdb는 새로운 하드디스크

- 파티션 하는법

```

```

