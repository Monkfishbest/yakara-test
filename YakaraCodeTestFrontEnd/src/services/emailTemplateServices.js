const templateApiUrl = "http://localhost:8080/templates"

const TemplateEmailServices = {
    getTemplates(){ 
        return fetch(templateApiUrl)
        .then(res => res.json())

    },

    



}

export default TemplateEmailServices

