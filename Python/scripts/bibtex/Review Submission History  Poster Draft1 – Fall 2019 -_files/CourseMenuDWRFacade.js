
// Provide a default path to dwr.engine
if (dwr == null) var dwr = {};
if (dwr.engine == null) dwr.engine = {};
if (DWREngine == null) var DWREngine = dwr.engine;

if (CourseMenuDWRFacade == null) var CourseMenuDWRFacade = {};
CourseMenuDWRFacade._path = '/webapps/assignment/dwr_open';
CourseMenuDWRFacade.isCourseContext = function(p0, callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'isCourseContext', p0, callback);
}
CourseMenuDWRFacade.isCourseContext = function(p0, callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'isCourseContext', p0, callback);
}
CourseMenuDWRFacade.setMenuDisplayMode = function(p0, p1, callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'setMenuDisplayMode', p0, p1, callback);
}
CourseMenuDWRFacade.loadCourse = function(p0, callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'loadCourse', p0, callback);
}
CourseMenuDWRFacade.getCourseTools = function(p0, callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'getCourseTools', p0, callback);
}
CourseMenuDWRFacade.initContextFromRequestHeader = function(callback) {
  dwr.engine._execute(CourseMenuDWRFacade._path, 'CourseMenuDWRFacade', 'initContextFromRequestHeader', false, callback);
}
