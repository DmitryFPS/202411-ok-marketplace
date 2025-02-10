import {JSX} from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import {HelmetProvider} from 'react-helmet-async';
import Layout from '../layout/layout.tsx';
import ScrollToTop from '../layout/components/ScrollToTop.ts';
import {AppRoute} from '../constants/constants.tsx';

function App(): JSX.Element {
  return (
    <HelmetProvider>
      <BrowserRouter>
        <ScrollToTop/>
        <Routes>
          <Route path={AppRoute.Root} element={<Layout/>}>
            <Route index element={<div>Страница в разработке</div>}/>
            <Route path="*" element={<div>Страница в разработке</div>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </HelmetProvider>
  );
}

export default App;
