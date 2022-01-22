export class PasswordChanger{
    public oldPassword : String;
    public newPassword : String;

    constructor(oldPass : String , newPass : String){
        this.oldPassword = oldPass;
        this.newPassword = newPass;
    }
}