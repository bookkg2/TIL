## 리눅스

##### 여러 개의 하드 디스크를 하나처럼 사용하기 

- 먼저 전에 있던 하드디스크를 제거하려면 기존에 fstab에 가서 mount 고정을 한것을 제거 한다 .
- 지웠던 것을 다시 가져오고 싶으면 'u'  하지만 안전하게 :q! 하고 다시 들어 온다 .

##### RAID 정의와 개념 

- 여러 개의 하드디스크를 하나의 하드디스크처럼 사용하는 방식이다. 
  - 비용을 절감하면서도 더 신괴성을 높이며, 성능까지 향상시킬 수 있다.
- 하드웨어 RAID 와 소프트웨어 RAID :
  - 소프트웨어 RAID는 저렴하고 하드웨어는 아주 비싸다.

- RIAD 레벨 : 단순 볼륨 , LInear RAID, RAID0, RAID1,RAID5,RAID6

  - LInear RAID 와 RAID0의 차이는 LInear RAID는 1개의 볼륨에서 앞 하드디스크에 완전히 저장되지 않으면 다음 하드디스크로 전혀 사용되지 않는다 .

  -  RAID0은 1의 볼륨에서 동시에 하드디스크를 사용한다. (빠르다. , 복구 불가능, 공간 효율성 좋음,결함 허용X)

  - 서버를 구성하는데 있어서 RAID는 필수이다. (하드디스크는 열이 많이 발생하므로!)

  - RAID1 : 한곳에 디스크가 저장되면 '미러링'을 해서 똑같은 데이터를 만들어 놓는다.(복구 가능,공간 효율성 나쁨, 결함 허용), 복제는 해당 디스크가 변화면 알아서 변화니깐 1G가 잡힌다(즉 1나의 공간). 

  -  RAID5 :  RAID1처럼 데이터의 안전성이 어느 정도 보당되면서 RAID 0 처럼 공간 효율성도 좋은 방식을 요구하게 된다. 이를 어느 정도 포용하는 방식이 RAID 5 다. 최소한 3개 이상의 하드디스크가 있어야만 구성이 가능하며 대개는 5개 이상의 하드디스크로 구성한다. 하드디스크에 오류가 발생하면 '패리티'를 이용해서 데이터를 복구할 수 있다 .  만약 짝수로 맞춘다면  패리티를 각각 짝수로 해놓는다. 즉 하나가 데이터가 망가지면 해당 데이터를 복구가 가능하다. 디스크는 3개지만 하나는 패이티 공간이여서 2G로 잡힌다(즉 2개의 공간만).

  - RAID 6 : RAID 5 방식을 사용할 때는 하드디스크가 1개 고장이 나도, 데이터에 이상이 없지만 2개의 하드디스크가 동시에 고장 난다면 복구할 수 없게 된다. 즉 RAID6은 2개의 패이티를 사용한다.  또한 최소4개의 하드디스크로 구성해야 한다.  공간 효율은 RAID5 보다 약간 낮은 반면에 데이터의 신뢰도는 더욱 높아지는 효과를 갖는다. 패이티를 2개를 사용함으로 성능도 약간 떨어진다. 

    > RAID의 장점  : 디스크가 모자르면 계속해서 붙일 수 있다.  

- 하는 법 : 

    (준비) VMware 오른쪽 아래 [Edit virtual machine settings] 를 클릭하여 [Hard Disk]를 각각 추가한다.

  >    SCSI 0:7은 사용할 수 없음(VMware에서 예약되어 있음)

  1. 각각의 DIsk fdisk -fd 라는 파일 시스템을 지정해야 한다.
     - fdisk /dev/sdb -> [SSCI 0:1] 하드디스크 선택
     - Command : n -> 새로운 파티션 분할
     - Select : p -> Primary 파티션 선택
     - Partition number :1 -> 파티션 번호 1번 선택
     - First sector : (Enter) -> 시작 섹터 번호
     - Last sector : (Enter) -> 마지막 섹터 번호
     - Command : t -> 파일 시스템 유형 선택
     - Hex Code :fd -> 'Linux raid autodetext' 유형
     - Command : p -> 설정 내용 확인
     - Command : w ->설정 저장 

     2. RAID 생성 : mdadm - 디스크묶기 (해당 레벨별로!)

        linear 예 )  mdadm --create /dev/md9 --level=linear --raid-devices=2 /dev/sdb1 /dev/sdc1

        :star:여기서 잠깐 ) 'mdadm' 명령어는 CentOS에서 RAID 장치를 생성/관리하는 명령어다. 

        > --create /dev/md9 ->md9 장치에 RAID를 생성
        >
        > --level=linear -> Linear RAID를 지정 , 0은 RAID0, 1은 RAID1등으로 지정한다.
        >
        > --raid-devices=2 /dev/sdb1 /dev/sdc2 -> 2개 하드디스크를 사용하며, 이어서 나오는 것은 장치 이름
        >
        > 그 외 자주 사용되는 명령은 다음과 같다.
        >
        > mdadm --stop /dev/md9 -> RAID 장치인 /dev/md9 를 중지 
        >
        > mdadm --run /dev/md9 -> 중지된 RAID 장치를 가동
        >
        > mdadm --detail /dev/md9 -> /dev/md9 장치의 상세한 내역을 출력 (전체는 SCAN 사용)

        

     3. mkfs.ex4 (포멧 과정)

        예 ) mkfs.ext4 /dev/md9

     4. forder 생성

        예 ) mkdir /이름

     5. mount

        예 ) mount /dev/md9 /raidLinear

        > df 명령어로 확인
        >
        > * LInearRAID는 모두 사용 하기 때문에 합친 메모리 공간이 나온다.
        > * RAID0 도 모두 사용하고 동작만 동시에 하기 때문에 합친 메모리 공간이 나온다.
        > * RAID1은 복제되는 것이기 때문에 메모리가 하나의 공간만 나타난다.
        > * RAID5는 하나는 '패리티' 공간 임으로 하나를 뺀 메모리 공간이 나타난다.
        >
        > 

     6. /etc/fstab 으로 reboot시에도 mount' 될 수 있도록 설정

        예 ) /dev/md9 /raidLinear ext4 defaults 1 2 

        > 'mdadm --detail /dev/md9'  

         

  :car: 뒤돌아 가는 법 : 역순으로 진행을 하고 , 파일 삭제는 'rm -rf /dev/md/*' 으로 삭제한다. (주의d) 

#### RAID에서 문제 발생과 조치 방법

- Edit에서 remove 하고 os를 시작하면 우리는 fstab에 mount를 할당 했기 때문에 제대로 Start 되지 않는다.

  -  해결 : '응답모드' 에서 /etc/fstab으로 들어가 해당 디스크 'mount'  를 없애고 다시 실행한다.

- RAID 1,5는 '결함 허용' 기능이 있다. 즉 1은 복제를 하기 때문에 , 5는 패리키 공간으로 하드디스크에 문제가 발생해도 저장된 데이터는 안전하다는 의미다. 

  > /dev/sdc(SCSI 0:2) 가 없어지면 /dev/sdc 장치가 없어지는 것은 아니고, SCSI 0:3 처럼 하나씩 밀리는 것이다.  

  

- 발생 상황 및 조치 ) 

  1) 먼저 확인을 위해 '/raidLinear' , '/raid0' , '/raid1', '/raid5' 디렉터리에 아무 파일이나 testFile이라는 이름으로 복사해넣는다.

  2) SCSI 0:2 , SCSI 0:4, SCSI 0:6, SCSI 0:8 하드디스크를 고장낸다.

  3)  상황 :  정상 작동 : Linear RAID(SCSI 0:1 (sdb)) , RAID 0 (SCSI 0:3 (sdc)) , RAID 1 (SCSI 0:5(sdd)), 

  ​                                     RAID 5(SCSI 0:8(sde)) , RAID 5 (SCSI 0:10(sdf)) , CentOS 설치된 디스크 (SCSI 0:0(sda))

  ​                 고  장 :  Linear RAID (SCSI 0:2) , RAID 0 (SCSI 0:4) , RAID 1 (SCSI 0:6)  , RAID 5(SCSI(0:10)) 

​        4) 부팅을 시작하면 부팅되지 않고 응급 모드로 접속될 것이다.

​        5) root 사용자의 비밀번호를 입력한다. 

​        6) 먼저 'ls -l /dev/sd*' 를 입력해 장치 이름을 확인해보자. 9개 였던 것이 5개만 남았을 것이다. 

​        7) 'df' 명령어를 입력하면 '/raidLinear' , '/raid0' , '/raid1' , '/raid5 ' 디렉터리는 보이지 않는다. 

​        8) 'mdadm --run /dev/md1' 을 입력해 우선 RAID 1 장치를 가동시키자. 'system -fack' 라는 메세지가 나오면 

​             (Enter)를 한번 입력하자.

​         9) 다시 'df' 명령어를 입력해 하드디스크 용량을 확인한 후 'ls -l /raid1' 을 입력하면 파일이 있을 것이다. 

> ​       RAID 1 은 복제해서 (미러링) 또다른 공간에 가지고 있으므로.          

​          10) 'mdadm --detail /dev/md1' 을 입력해 RAID 1 장치가 어떻게 작동하는지 상세히 확인

>  총 2개의 하드디스크 중에서 1개가 작동함을 확인 할 수 있다. RAID 1에서 작동되는 장치는 /dev/sdd가             작동된다. 비록 2개 중 하나만 작동하지만 결합 허용 기능으로 인해 데이터는 안전하게 보관된 것이다. 

​            11)  동일한 방식으로 RAID 5 를 확인해 보면 똑같은 결과를 확인 할 수 있다. 

> RAID 5 도 패리티공간에 저장 되어 있긴 때문에 디스크 하나만 고장나면 복원이 가능하다. 그이상은 힘들다. 왜냐하면 ? 패리티 공간의 짝수, 홀수 로 약속되어있는 것으로 저장하기 때문에!

​             12) 'mdadm --run /dev/md9' ,'mdadm --run /dev/md0' 을 입력해 다시 가동시켜보자. 작동 자체를 하지 

​                     않는다.

> md9와 md0 은 손상 되면 복원을 할 수 가 없기 때문에

​             13) 'mdadm --stop /dev/md9' , 'mdadm --stop /dev/md0' 을 입력해 LinearRAIN와 RAID0을 중지한다.

​             14) vi 에디터로 /etc/fstab을 열어서 /dev/md9 와 /dev/md0 두 행을 주석을 붙인 후 저장한다. 

​             15) reboot 으로 재부팅 한다. 

​             16) [Edit Virtual Machine Settings] 를 클릭해서 기존에 손상 시킨 하드디스크 정보와 같이 4개 더 추가         

> 파일이름은 헷갈릴 수 있으니 별도로 구별한다. 또한 새로운 하드디스크를 추가했다고 자동으로 RAID 장치가 복구되는 것은 아니다. 직접 수동으로 복구해야한다.

​              17) fdisk를 통해 /dev/sdc(SCSI 0:2) , /dev/sde(SCSI 0:4) , /dev/sdg(SCSI 0:6) , /dev/sdi(SCSI 0:9) 의 파일                  					시스템을 만들자

​				     - 위에 하는 법  1) 참고



 			  18) 'ls /dev/sd*' 으로 파티션이 작성되었는지 확인.

​               19) 'mdadm --stop /dev/md9' 를 입력해 Linear RAID 장치를 중지하고 'mdadm --create /dev/md9 --       					level=linear' --raid-devices=2 /dev/sdb1 /dev/sdc1' 을 입력해 다시 구성한다.확인 메세지가 나오면 y					를 입력

   			 20) 같은 방식으로 'mdadm --stop /dev/md0' 을 입력해 md0을 중지하고 , 'mdadm --create /dev/md0 						--level=0 --raid-devices=2 /dev/sdd1 /dev/sde1'을 입력해 구성한다. 

​                 21) 이제 다시 'mdadm --detail /dev/md9' , 'mdadm --detail/dev/md0' 를 입력해 두 RAID 장치를 확인						하면 처음과 동일하게 잘 작동할 것이다.

​                 22) 이제는 결합 허용이 있는 RAID 1과 RAID 5을 구성 

​                        -RAID 1은 하드디스크가 1개 빠졌으 뿐 잘 작동한다.(그대로 복제되 공간에 남아 있기 때문에) 그러   						므로 새로운 하드디스크만 추가하는 명령인 'mdadm /dev/md1 --add/dev/sdg1' 을 입력함

>   /dev/md1 이라는 RAID 장치에 /dev/sdg1 파티션을 추가하라는 것이다. 기존에 md1 에고장난 정보의 파티션이(/dev/sdg(SCSI 0:6)) 아니여도 된다는 것을 알 수 있다.

​					23) 'mdadm /dev/md5 --add /dev/sdi1'를 입력해서 같은 방식으로 RAID 5를 재구성하자.

​                    24) 'mdadm -detail /dev/md1' 과 'mdadm -detail /dev/md1' 를 입력해서 RAID 장치가 잘 작동되는							지 확인하자. 

> 만약 RAID 5 장치의 4번 장치가 'spare rebuilding /dev/sdi1' 으로 표시되면 현재 RAID 5를 재구성하는 상태이기 때문에 잠시 기다렸다가 다시 확인하면 된다. 

​                   25) vi /etc/fstab 을 열어서 , 앞에 주석(#)을 표시했던 /dev/md9 과 /dev/md0의 주석을 제거하자.

​                   26) reboot 한다. (정상적으로 부팅될 것이다.)

​				     :star:만약, 다시 응급 모드가 나온다면 일단 비밀번호인 'password' 를 입력해서 root 사용자로 접속한						다. 그리고 'fsck -y /dev/md0'를 실행해서 RAID 0 장치의 파일 시스템 오류를 수정한 후 'reboot' 한						다. 기존에 사용하던 하드디스크 (SCSI 0:3) 번에 아직 쓰레기 값이 남아 있기 때문이다. 	

​                    27)  'ls' 명령어를 입력해 '/raid0' 디렉터리를 확인하면 당연히 testFile이 보이지 않아야 하지만 보인다							면 정상 파일이 아닌 50%만 정상인 파일이다. 그러므로 'umount' 를 시도하고 'mkfs'명령으로 깨							끗이 포맷하는 것이 좋다.    

​                    

​                     28) 이번에는 'ls' 명령어를 입력해 '/raidLinear' 디렉터리를 확인하자. 기존의 testFile이 보일 것이다.							즉 복구가 되었다.