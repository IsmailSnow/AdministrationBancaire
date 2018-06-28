import { ApiFrontPage } from './app.po';

describe('api-front App', () => {
  let page: ApiFrontPage;

  beforeEach(() => {
    page = new ApiFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
