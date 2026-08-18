'use client';

import {Container, Title, Text, Button, Stack, Group} from '@mantine/core';
import Link from 'next/link';
import {ColorSchemeToggle} from '@/components/ColorSchemeToggle';
import {MyCoolComponent} from "@/components/MyCoolComponent";

export default function KataPage() {
  return (
      <Container size="lg" py="xl">
        <Stack gap="xl">
          <Group justify="space-between">
            <Button component={Link} href="/" variant="light">
              ← Back to Home
            </Button>
            <ColorSchemeToggle/>
          </Group>
          <Group>
            <MyCoolComponent name="Kata"/>
          </Group>
        </Stack>
      </Container>
  );
}
