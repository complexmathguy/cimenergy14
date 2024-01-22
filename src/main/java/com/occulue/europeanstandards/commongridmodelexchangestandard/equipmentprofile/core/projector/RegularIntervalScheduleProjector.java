/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for RegularIntervalSchedule as outlined for the CQRS pattern. All event handling and
 * query handling related to RegularIntervalSchedule are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by RegularIntervalScheduleAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("regularIntervalSchedule")
@Component("regularIntervalSchedule-projector")
public class RegularIntervalScheduleProjector extends RegularIntervalScheduleEntityProjector {

  // core constructor
  public RegularIntervalScheduleProjector(
      RegularIntervalScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = CreateRegularIntervalScheduleEvent.class)
  public void handle(CreateRegularIntervalScheduleEvent event) {
    LOGGER.info("handling CreateRegularIntervalScheduleEvent - " + event);
    RegularIntervalSchedule entity = new RegularIntervalSchedule();
    entity.setRegularIntervalScheduleId(event.getRegularIntervalScheduleId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event UpdateRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = UpdateRegularIntervalScheduleEvent.class)
  public void handle(UpdateRegularIntervalScheduleEvent event) {
    LOGGER.info("handling UpdateRegularIntervalScheduleEvent - " + event);

    RegularIntervalSchedule entity = new RegularIntervalSchedule();
    entity.setRegularIntervalScheduleId(event.getRegularIntervalScheduleId());
    entity.setEndTime(event.getEndTime());
    entity.setTimeStep(event.getTimeStep());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegularIntervalSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event DeleteRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = DeleteRegularIntervalScheduleEvent.class)
  public void handle(DeleteRegularIntervalScheduleEvent event) {
    LOGGER.info("handling DeleteRegularIntervalScheduleEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    RegularIntervalSchedule entity = delete(event.getRegularIntervalScheduleId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event AssignEndTimeToRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = AssignEndTimeToRegularIntervalScheduleEvent.class)
  public void handle(AssignEndTimeToRegularIntervalScheduleEvent event) {
    LOGGER.info("handling AssignEndTimeToRegularIntervalScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RegularIntervalSchedule entity =
        assignEndTime(event.getRegularIntervalScheduleId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegularIntervalSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event UnAssignEndTimeFromRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = UnAssignEndTimeFromRegularIntervalScheduleEvent.class)
  public void handle(UnAssignEndTimeFromRegularIntervalScheduleEvent event) {
    LOGGER.info("handling UnAssignEndTimeFromRegularIntervalScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RegularIntervalSchedule entity = unAssignEndTime(event.getRegularIntervalScheduleId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegularIntervalSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event AssignTimeStepToRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = AssignTimeStepToRegularIntervalScheduleEvent.class)
  public void handle(AssignTimeStepToRegularIntervalScheduleEvent event) {
    LOGGER.info("handling AssignTimeStepToRegularIntervalScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    RegularIntervalSchedule entity =
        assignTimeStep(event.getRegularIntervalScheduleId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegularIntervalSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /*
   * @param	event UnAssignTimeStepFromRegularIntervalScheduleEvent
   */
  @EventHandler(payloadType = UnAssignTimeStepFromRegularIntervalScheduleEvent.class)
  public void handle(UnAssignTimeStepFromRegularIntervalScheduleEvent event) {
    LOGGER.info("handling UnAssignTimeStepFromRegularIntervalScheduleEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    RegularIntervalSchedule entity = unAssignTimeStep(event.getRegularIntervalScheduleId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindRegularIntervalSchedule(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllRegularIntervalSchedule(entity);
  }

  /**
   * Method to retrieve the RegularIntervalSchedule via an RegularIntervalSchedulePrimaryKey.
   *
   * @param id Long
   * @return RegularIntervalSchedule
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public RegularIntervalSchedule handle(FindRegularIntervalScheduleQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getRegularIntervalScheduleId());
  }

  /**
   * Method to retrieve a collection of all RegularIntervalSchedules
   *
   * @param query FindAllRegularIntervalScheduleQuery
   * @return List<RegularIntervalSchedule>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<RegularIntervalSchedule> handle(FindAllRegularIntervalScheduleQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindRegularIntervalSchedule, but only if the id matches
   *
   * @param entity RegularIntervalSchedule
   */
  protected void emitFindRegularIntervalSchedule(RegularIntervalSchedule entity) {
    LOGGER.info("handling emitFindRegularIntervalSchedule");

    queryUpdateEmitter.emit(
        FindRegularIntervalScheduleQuery.class,
        query ->
            query
                .getFilter()
                .getRegularIntervalScheduleId()
                .equals(entity.getRegularIntervalScheduleId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllRegularIntervalSchedule
   *
   * @param entity RegularIntervalSchedule
   */
  protected void emitFindAllRegularIntervalSchedule(RegularIntervalSchedule entity) {
    LOGGER.info("handling emitFindAllRegularIntervalSchedule");

    queryUpdateEmitter.emit(FindAllRegularIntervalScheduleQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(RegularIntervalScheduleProjector.class.getName());
}
