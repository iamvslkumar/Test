import React, { useState, useEffect } from "react";
import axios from "axios";

const CreateJiraTicket = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [projectKey, setProjectKey] = useState("");

  useEffect(() => {
    // Get the Jira API credentials from the environment
    const jiraCredentials = {
      username: process.env.JIRA_USERNAME,
      password: process.env.JIRA_PASSWORD,
    };

    // Create a new axios instance with the Jira API credentials
    const axiosInstance = axios.create({
      baseURL: "https://your-jira-server.com/rest/api/2/",
      headers: {
        "Access-Control-Allow-Origin": "*",
        Authorization: `Basic ${btoa(jiraCredentials.username + ":" + jiraCredentials.password)}`,
      },
    });

    // Listen for changes to the input fields
    setTitle(event => {
      setTitle(event.target.value);
    });
    setDescription(event => {
      setDescription(event.target.value);
    });
    setProjectKey(event => {
      setProjectKey(event.target.value);
    });

    // Create a new Jira ticket when the user clicks the "Create Ticket" button
    const createTicket = () => {
      axiosInstance
        .post(`/issue`, {
          projectKey: projectKey,
          summary: title,
          description: description,
        })
        .then(response => {
          console.log("Ticket created successfully!");
        })
        .catch(error => {
          console.log("Error creating ticket:", error);
        });
    };

    // Add the "Create Ticket" button to the DOM
    const createTicketButton = (
      <button onClick={createTicket}>Create Ticket</button>
    );

    return (
      <div>
        <h1>Create Jira Ticket</h1>
        <input
          type="text"
          placeholder="Title"
          onChange={setTitle}
        />
        <br />
        <textarea
          rows="10"
          cols="50"
          placeholder="Description"
          onChange={setDescription}
        />
        <br />
        <input
          type="text"
          placeholder="Project Key"
          onChange={setProjectKey}
        />
        <br />
        {createTicketButton}
      </div>
    );
  }, []);
};

export default CreateJiraTicket;
