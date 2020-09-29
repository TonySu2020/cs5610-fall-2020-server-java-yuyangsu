(function () {
  var $userId;
  var $usernameFld, $passwordFld;
  var $removeBtn, $editBtn, $searchBtn, $createBtn, $updateBtn;
  var $firstNameFld, $lastNameFld, $roleFld;
  var $userRowTemplate, $tbody;
  var userService = new AdminUserServiceClient();

  // let users = [
  //   {
  //     username: 'alice',
  //     first: 'Alice',
  //     lName: 'Wonderland',
  //     role: 'Faculty'
  //   },
  //   {
  //     username: 'bob',
  //     first: 'Robert',
  //     lName: 'Marley',
  //     role: 'Faculty'
  //   },
  //   {
  //     username: 'charlie',
  //     first: 'Charlie',
  //     lName: 'Garcia',
  //     role: 'Faculty'
  //   }
  // ]

  $(main);

  function main() {
    $usernameFld = $("#usernameFld");
    $passwordFld = $("#passwordFld");
    $removeBtn = $(".wbdv-remove")
    $editBtn = $(".wbdv-edit");
    $searchBtn = $(".wbdv-search").click(() => findUserById($userId));
    $createBtn = $(".wbdv-create").click(createUser);
    $updateBtn = $(".wbdv-update").click(() => updateUser());
    $firstNameFld = $("#firstNameFld");
    $lastNameFld = $("#lastNameFld");
    $roleFld = $("#roleFld");
    $userRowTemplate = $("tr.wbdv-template");
    $tbody = $("tbody");

    findAllUsers();
  }

  function createUser() {
    const username = $usernameFld.val();
    const firstname = $firstNameFld.val();
    const lastname = $lastNameFld.val();
    const role = $roleFld.val();

    const newUser = {
      username: username,
      first: firstname,
      last: lastname,
      role: role
    };

    userService.createUser(newUser)
    .then(actualNewUser => {
      findAllUsers();
    });
  }

  function findAllUsers() {

    userService.findAllUsers().then((users) => {
      renderUsers(users);
    })
  }

  function findUserById(userId) {
    // userService.findUserById(userId).then(response => {
    //   alert("Found: ", response)
    // })
  }

  function deleteUser(user) {
    const userId = user._id;
    userService.deleteUser(userId)
    .then(response => {
      findAllUsers();
    })
  }

  function selectUser(user) {
    $userId = user._id;
    $usernameFld.val(user.username);
    $firstNameFld.val(user.first);
    $lastNameFld.val(user.last);
    $roleFld.val(user.role);

  }

  function updateUser() {

    const username = $usernameFld.val();
    const firstname = $firstNameFld.val();
    const lastname = $lastNameFld.val();
    const role = $roleFld.val();

    const newUser = {
      username: username,
      first: firstname,
      last: lastname,
      role: role
    };

    userService.updateUser($userId, newUser).then(response => {
      findAllUsers();
    });
  }

  function renderUser(user) {
    const row = $userRowTemplate.clone();
    row.removeClass("wbdv-hidden");
    row.find(".wbdv-username").html(user.username);
    row.find(".wbdv-first-name").html(user.first);
    row.find(".wbdv-last-name").html(user.last);
    row.find(".wbdv-role").html(user.role);
    row.find(".wbdv-remove").click(() => deleteUser(user));
    row.find(".wbdv-edit").click(() => selectUser(user));

    $tbody.append(row);
  }

  function renderUsers(users) {
    $tbody.empty();
    for (let i = 0; i < users.length; i++) {
      const user = users[i];
      renderUser(user);
    }
  }

})();
