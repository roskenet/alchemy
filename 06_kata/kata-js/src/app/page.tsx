import {
  Badge,
  Button,
  Card,
  Code,
  Container,
  Group,
  Stack,
  Text,
  Title,
} from "@mantine/core";

export default function Home() {
  return (
    <Container size="sm" py={{ base: "xl", md: "4rem" }}>
      <Card withBorder radius="lg" shadow="sm" padding="xl">
        <Stack gap="lg">
          <div>
            <Badge variant="light">Mantine installed</Badge>
            <Title order={1} mt="md">
              <p>Willkommen!</p>
            </Title>
            <p>This is my code kata playground.</p>
          </div>

          <Group>
            <Button
              component="a"
              href="https://mantine.dev/getting-started/"
              target="_blank"
              rel="noreferrer"
            >
              Open Mantine docs
            </Button>
            <Button
              component="a"
              variant="default"
              href="https://nextjs.org/docs"
              target="_blank"
              rel="noreferrer"
            >
              Next.js docs
            </Button>
          </Group>
        </Stack>
      </Card>
    </Container>
  );
}
