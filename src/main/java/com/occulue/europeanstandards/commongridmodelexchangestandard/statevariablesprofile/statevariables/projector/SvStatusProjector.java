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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SvStatus as outlined for the CQRS pattern. All event handling and query handling
 * related to SvStatus are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SvStatusAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("svStatus")
@Component("svStatus-projector")
public class SvStatusProjector extends SvStatusEntityProjector {

  // core constructor
  public SvStatusProjector(SvStatusRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSvStatusEvent
   */
  @EventHandler(payloadType = CreateSvStatusEvent.class)
  public void handle(CreateSvStatusEvent event) {
    LOGGER.info("handling CreateSvStatusEvent - " + event);
    SvStatus entity = new SvStatus();
    entity.setSvStatusId(event.getSvStatusId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event UpdateSvStatusEvent
   */
  @EventHandler(payloadType = UpdateSvStatusEvent.class)
  public void handle(UpdateSvStatusEvent event) {
    LOGGER.info("handling UpdateSvStatusEvent - " + event);

    SvStatus entity = new SvStatus();
    entity.setSvStatusId(event.getSvStatusId());
    entity.setInService(event.getInService());
    entity.setSvStatus(event.getSvStatus());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvStatus(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event DeleteSvStatusEvent
   */
  @EventHandler(payloadType = DeleteSvStatusEvent.class)
  public void handle(DeleteSvStatusEvent event) {
    LOGGER.info("handling DeleteSvStatusEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SvStatus entity = delete(event.getSvStatusId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event AssignInServiceToSvStatusEvent
   */
  @EventHandler(payloadType = AssignInServiceToSvStatusEvent.class)
  public void handle(AssignInServiceToSvStatusEvent event) {
    LOGGER.info("handling AssignInServiceToSvStatusEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvStatus entity = assignInService(event.getSvStatusId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvStatus(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event UnAssignInServiceFromSvStatusEvent
   */
  @EventHandler(payloadType = UnAssignInServiceFromSvStatusEvent.class)
  public void handle(UnAssignInServiceFromSvStatusEvent event) {
    LOGGER.info("handling UnAssignInServiceFromSvStatusEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvStatus entity = unAssignInService(event.getSvStatusId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvStatus(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event AssignSvStatusToSvStatusEvent
   */
  @EventHandler(payloadType = AssignSvStatusToSvStatusEvent.class)
  public void handle(AssignSvStatusToSvStatusEvent event) {
    LOGGER.info("handling AssignSvStatusToSvStatusEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvStatus entity = assignSvStatus(event.getSvStatusId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvStatus(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /*
   * @param	event UnAssignSvStatusFromSvStatusEvent
   */
  @EventHandler(payloadType = UnAssignSvStatusFromSvStatusEvent.class)
  public void handle(UnAssignSvStatusFromSvStatusEvent event) {
    LOGGER.info("handling UnAssignSvStatusFromSvStatusEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvStatus entity = unAssignSvStatus(event.getSvStatusId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvStatus(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvStatus(entity);
  }

  /**
   * Method to retrieve the SvStatus via an SvStatusPrimaryKey.
   *
   * @param id Long
   * @return SvStatus
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SvStatus handle(FindSvStatusQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSvStatusId());
  }

  /**
   * Method to retrieve a collection of all SvStatuss
   *
   * @param query FindAllSvStatusQuery
   * @return List<SvStatus>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SvStatus> handle(FindAllSvStatusQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSvStatus, but only if the id matches
   *
   * @param entity SvStatus
   */
  protected void emitFindSvStatus(SvStatus entity) {
    LOGGER.info("handling emitFindSvStatus");

    queryUpdateEmitter.emit(
        FindSvStatusQuery.class,
        query -> query.getFilter().getSvStatusId().equals(entity.getSvStatusId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSvStatus
   *
   * @param entity SvStatus
   */
  protected void emitFindAllSvStatus(SvStatus entity) {
    LOGGER.info("handling emitFindAllSvStatus");

    queryUpdateEmitter.emit(FindAllSvStatusQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SvStatusProjector.class.getName());
}
