# Git Branch를 통한 코드관리

## I. Branch 란?

사용하게 되는 이유?

- 예전에는 App을 서비스 하려면 FTP방식으로 파일을 일일히 올렸음 ( 협업불가)
- 이제는 git에만 올려도 (CI & CD 방식) 코드가 자동으로 서비스에 적용됨.
- 때문에 master에 새로운 기능을 추가하거나 할때 바로 메인 서비스에 적용 됨..
- 따라서 Main에 있는 코드를 건들이지 않고 Develop용 Branch를 따로 만들어서 개발.후 Merge랄까.
- 보통 하나의 기능을 개발할떄 Branch하나씩 만들어서 개발후 Develop에 합치고 테스트를 거쳐 Main 에 합치는 식...

Git은 Branch들을 다른 하나의 독립된 세계처럼 인식한다. 절대 서로의 코드에 간섭 x.

Branch는 일회용이다 !

<https://git-school.github.io/visualizing-git/>

Create Branch (Default Branch : Master)

```
git branch [branch name]

ex) git branch test
ex) git branch
* master
  test

//branch를 만들면서 이동.
git checkout -b neo
git switch -c neo 
```

Switch Branch

```
git switch [branch name]
ex) git switch test
```

or

Checkout branch

```
git checkout [branchout]
원래는 이거였는데 최신버전에서 switch가 추가됨
```

Merge

- Fast-Forward

  ```
  ex) git merge test
  ```

Delete Branch

```
git branch -d [Branch name]
git branch -d test
```

II. Git Visualization

<https://git-school.github.io/visualizing-git\>

git flow ?

III. Merge 시나리오

- 항상 Merge 할때 Main이 될 branch로가서 Merge하면 됨.

```
git reset --hard HEAD
```

1. Fast forward Merge

   ```
   git merge test
   ```

2. Auto merge

   conflict없이 서로 다른파일 수정해서 merge 하면 자동으로 commit하나 만들면서 merge해줌

   ```
   git log --oneline --graph
   ```

3. Merge with Conflict

   Merge시 conflict가 나면 자동으로 인지하고 수정을 요구함.. GUIDE대로 따라서 수정 후 다시 commit하면 됨.