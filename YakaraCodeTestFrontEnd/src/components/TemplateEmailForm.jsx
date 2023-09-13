import { useEffect, useState } from "react";
import TemplateEmailServices from "../services/emailTemplateServices"
import "../styles/TemplateEmailForm.css"

const TemplateEmailForm = () => {
    const [emailTemplates, setEmailTemplates] = useState([])

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [selectedTemplate, setSelectedTemplate] = useState({});

    useEffect(() => {
        TemplateEmailServices.getTemplates()
        .then(emailTemplates => {
            setEmailTemplates(emailTemplates)
            setSelectedTemplate(emailTemplates[0])
        })
    }, [])

    const emailTemplatesDropDown = emailTemplates.map((template) => {
        return (
            <option key={template.id}value={template.id}>{template.templateName}</option>
        )
    })

    const handleSetSelectedTemplate = (evt) => {
        const templateId = evt.target.value 
        const emailTemplateToSelect = emailTemplates.find(template => template.id == templateId)
        console.log(emailTemplateToSelect)
        setSelectedTemplate(emailTemplateToSelect)
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Name:', name);
        console.log('Email:', email);
        console.log('Selected Template:', selectedTemplate);
    };

    return (
        <>
            <form onSubmit={handleSubmit} >
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        id="name"
                        value={name}
                        onChange={(evt) => setName(evt.target.value)}
                        required
                    />
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(evt) => setEmail(evt.target.value)}
                        required
                    />
                    <label htmlFor="template">Select Email Template:</label>
                    <select
                        id="template"
                        value={selectedTemplate}
                        onChange={handleSetSelectedTemplate}
                        required
                    >
                        <option disabled > -- select a template -- </option>
                        {emailTemplatesDropDown}
                    </select>
                <button type="submit">Submit</button>
            </form>
            <span> Template content preview</span>
            { selectedTemplate !== {} ? <p id="text-box">{selectedTemplate.templateContent}</p> : <p>loading</p>}
        </>
    );
}

export default TemplateEmailForm