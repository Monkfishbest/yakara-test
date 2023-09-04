import { useEffect, useState } from "react";

const TemplateEmailForm = () => {


    const [emailTemplates, setEmailTemplates] = useState([])

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [selectedTemplate, setSelectedTemplate] = useState('');

    useEffect(() => {

    }, [])

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Name:', name);
        console.log('Email:', email);
        console.log('Selected Template:', selectedTemplate);
    };

    return (
        <>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        id="name"
                        value={name}
                        onChange={(evt) => setName(evt.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={(evt) => setEmail(evt.target.value)}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="template">Select Email Template:</label>
                    <select
                        id="template"
                        value={selectedTemplate}
                        onChange={(evt) => setSelectedTemplate(evt.target.value)}
                        required
                    >
                        <option value="">Select a template</option>
                        <option value="template1">Template 1</option>
                        <option value="template2">Template 2</option>
                        <option value="template3">Template 3</option>
                    </select>
                </div>
                <button type="submit">Submit</button>
            </form>
        </>
    );
}

export default TemplateEmailForm