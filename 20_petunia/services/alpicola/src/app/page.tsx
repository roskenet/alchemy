"use client";

import { Typography, Layout, Space } from 'antd';
import Link from 'next/link';
import Image from 'next/image';

const { Title, Paragraph } = Typography;
const { Content } = Layout;

export default function Home() {
  return (
    <Layout style={{ minHeight: '100vh', background: 'var(--background)' }}>
      <Content style={{ 
        padding: '50px', 
        display: 'flex', 
        flexDirection: 'column', 
        justifyContent: 'center', 
        alignItems: 'center' 
      }}>
        <Space direction="vertical" align="center">
          <Image src="/img/chocolina.jpg" width={300} height={300} alt="Chocolina" />
          <Title level={1}>Hello World!</Title>
          <Paragraph>This is my webservice garden!</Paragraph>
          <Link href="/petunias">My Petunias</Link>
        </Space>
      </Content>
    </Layout>
  );
}
