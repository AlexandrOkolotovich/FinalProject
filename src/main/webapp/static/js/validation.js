function formValidation()
{
    var upassword = document.registration.password;
    var uname = document.registration.username;
    var usurname = document.registration.surname;
    var uemail = document.registration.email;
    var uphone = document.registration.phone;

        if(passid_validation(upassword,7,12))
        {
            if(allLetter(uname))
            {
                if(alphanumeric(uadd))
                {
                    if(countryselect(ucountry))
                    {
                        if(allnumeric(uzip))
                        {
                            if(ValidateEmail(uemail))
                            {
                                if(validsex(umsex,ufsex))
                                {
                                }
                            }
                        }
                    }
                }
            }
        }

    return false;
}