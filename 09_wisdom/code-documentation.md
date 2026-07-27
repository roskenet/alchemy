# Skill: Code Architecture Documentation

## Description
Analyzes, breaks down, and documents a specific class, method, or software workflow. Use this skill when the user provides source code and requests a clear explanation or needs the findings saved directly into a structured Markdown file format.

## Context and Guardrails
- **Purpose**: Transform complex source code into human-readable engineering documentation.
- **Tone**: Professional, clear, objective, and technical.
- **Formatting Rule**: Output ONLY valid Markdown syntax. 
- **Do NOT**: Include introductory conversational filler (e.g., "Sure, here is your documentation").
- **Do NOT**: Hallucinate or guess code intent. If a dependency or method logic is ambiguous, list it under "Assumptions".
- **Code Snippets**: Keep snippets inside the documentation short. Focus on logic flow rather than copying the entire codebase back to the user.

## Execution Steps

### Phase 1: Context Gathering & Mapping
1. Identify the primary component: Class, Method, or Workflow.
2. Map all inputs, parameters, outputs, return types, and external dependencies.
3. Track the logical path from the entry point to the exit point.

### Phase 2: Documentation Generation
Generate the final response using exactly this Markdown structure:

# Technical Documentation: [Component Name]

## 1. Overview
[A 2-3 sentence high-level summary of what this component does and its role in the system.]

## 2. Component Details
- **Type**: [Class / Method / Workflow]
- **Inputs/Parameters**: [List types and purposes]
- **Outputs/Returns**: [List types and purposes]
- **Dependencies**: [List external libraries or internal classes called]

## 3. Step-by-Step Workflow Logic
[Provide an ordered, numbered list detailing the exact chronological execution flow of the code.]

## 4. Key Architectural Decisions & Edge Cases
- **Error Handling**: [How does it handle failures?]
- **Performance/Complexity**: [Notable time/space complexities or efficiency choices if visible]
- **Assumptions**: [Any missing context or assumptions made during analysis]

## Phase 3: Self-Verification
Before outputting the Markdown file, verify the following:
1. Did I skip conversational pleasantries?
2. Are all Markdown headers (`#`, `##`) correctly formatted?
3. Is every step in the workflow technically accurate based *only* on the provided code?
