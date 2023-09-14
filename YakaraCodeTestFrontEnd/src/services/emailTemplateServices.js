const templateApiUrl = "http://localhost:8080/templates"
const emailRecordApiUrl = "http://localhost:8080/email-records"


const TemplateEmailServices = {
    getTemplates(){ 
        return fetch(templateApiUrl)
        .then(res => res.json())
    },

    postRecord(emailRecord){
        return fetch(emailRecordApiUrl,{
            method:"POST",
            body: JSON.stringify(emailRecord),
            headers: {'Content-Type':'application/json'}
        })
    }





}

export default TemplateEmailServices

