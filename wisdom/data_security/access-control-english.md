# Data Access & Security: Key Talking Points

## Why unrestricted read access to "unimportant" data is problematic

### 1. Perceived irrelevance is not a security principle
"This data isn't interesting to outsiders" is not a valid justification for broad access.
- Data that seems irrelevant today might become valuable or risky in a different context.
- Attackers don’t assess data based on our internal perception — they exploit availability and combinability.

### 2. Need-to-know is a core security concept
Access should always be granted based on a legitimate business need — not convenience or assumptions.
- Giving read access to all 20,000 employees violates basic access control principles.
- Even seemingly harmless data can be:
  * inadvertently shared or leaked  
  * reused in shadow IT tools  
  * misinterpreted or misused

### 3. Transparency != unrestricted access
Internal transparency does not require full data exposure.
- Share insights via:
  * dashboards or curated views  
  * documented access requests  
  * limited, traceable exports  
- Raw data access should be the exception, not the default.

### 4. Scalability, auditing & future-proofing
Unrestricted access:
- complicates audits and compliance reporting  
- undermines future zero-trust architecture  
- makes incident response harder, since too many accounts are affected

### 5. Responsibility beats convenience
Openness must not replace governance.
- Broad access shifts responsibility away from owners.  
- Controlled access allows teams to stay accountable for the data they manage.  
- If everyone has access, no one is responsible.

## What’s a better approach?
- Grant access based on roles, projects or departments.  
- Use request-based access with lightweight approval.  
- Offer dashboards instead of raw data.  
- Log access and review it regularly.

## Summary
> "Even if data is not confidential, unrestricted access creates risks. Our security posture should not be based on whether data seems uninteresting — but on our ability to control who sees what, and why. You can't protect what you don’t control."

