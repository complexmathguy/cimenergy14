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
 * Projector for SvPowerFlow as outlined for the CQRS pattern. All event handling and query handling
 * related to SvPowerFlow are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SvPowerFlowAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("svPowerFlow")
@Component("svPowerFlow-projector")
public class SvPowerFlowProjector extends SvPowerFlowEntityProjector {

  // core constructor
  public SvPowerFlowProjector(
      SvPowerFlowRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSvPowerFlowEvent
   */
  @EventHandler(payloadType = CreateSvPowerFlowEvent.class)
  public void handle(CreateSvPowerFlowEvent event) {
    LOGGER.info("handling CreateSvPowerFlowEvent - " + event);
    SvPowerFlow entity = new SvPowerFlow();
    entity.setSvPowerFlowId(event.getSvPowerFlowId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event UpdateSvPowerFlowEvent
   */
  @EventHandler(payloadType = UpdateSvPowerFlowEvent.class)
  public void handle(UpdateSvPowerFlowEvent event) {
    LOGGER.info("handling UpdateSvPowerFlowEvent - " + event);

    SvPowerFlow entity = new SvPowerFlow();
    entity.setSvPowerFlowId(event.getSvPowerFlowId());
    entity.setP(event.getP());
    entity.setQ(event.getQ());
    entity.setSvPowerFlow(event.getSvPowerFlow());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event DeleteSvPowerFlowEvent
   */
  @EventHandler(payloadType = DeleteSvPowerFlowEvent.class)
  public void handle(DeleteSvPowerFlowEvent event) {
    LOGGER.info("handling DeleteSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SvPowerFlow entity = delete(event.getSvPowerFlowId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event AssignPToSvPowerFlowEvent
   */
  @EventHandler(payloadType = AssignPToSvPowerFlowEvent.class)
  public void handle(AssignPToSvPowerFlowEvent event) {
    LOGGER.info("handling AssignPToSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvPowerFlow entity = assignP(event.getSvPowerFlowId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event UnAssignPFromSvPowerFlowEvent
   */
  @EventHandler(payloadType = UnAssignPFromSvPowerFlowEvent.class)
  public void handle(UnAssignPFromSvPowerFlowEvent event) {
    LOGGER.info("handling UnAssignPFromSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvPowerFlow entity = unAssignP(event.getSvPowerFlowId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event AssignQToSvPowerFlowEvent
   */
  @EventHandler(payloadType = AssignQToSvPowerFlowEvent.class)
  public void handle(AssignQToSvPowerFlowEvent event) {
    LOGGER.info("handling AssignQToSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvPowerFlow entity = assignQ(event.getSvPowerFlowId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event UnAssignQFromSvPowerFlowEvent
   */
  @EventHandler(payloadType = UnAssignQFromSvPowerFlowEvent.class)
  public void handle(UnAssignQFromSvPowerFlowEvent event) {
    LOGGER.info("handling UnAssignQFromSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvPowerFlow entity = unAssignQ(event.getSvPowerFlowId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event AssignSvPowerFlowToSvPowerFlowEvent
   */
  @EventHandler(payloadType = AssignSvPowerFlowToSvPowerFlowEvent.class)
  public void handle(AssignSvPowerFlowToSvPowerFlowEvent event) {
    LOGGER.info("handling AssignSvPowerFlowToSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    SvPowerFlow entity = assignSvPowerFlow(event.getSvPowerFlowId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /*
   * @param	event UnAssignSvPowerFlowFromSvPowerFlowEvent
   */
  @EventHandler(payloadType = UnAssignSvPowerFlowFromSvPowerFlowEvent.class)
  public void handle(UnAssignSvPowerFlowFromSvPowerFlowEvent event) {
    LOGGER.info("handling UnAssignSvPowerFlowFromSvPowerFlowEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    SvPowerFlow entity = unAssignSvPowerFlow(event.getSvPowerFlowId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSvPowerFlow(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSvPowerFlow(entity);
  }

  /**
   * Method to retrieve the SvPowerFlow via an SvPowerFlowPrimaryKey.
   *
   * @param id Long
   * @return SvPowerFlow
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SvPowerFlow handle(FindSvPowerFlowQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSvPowerFlowId());
  }

  /**
   * Method to retrieve a collection of all SvPowerFlows
   *
   * @param query FindAllSvPowerFlowQuery
   * @return List<SvPowerFlow>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SvPowerFlow> handle(FindAllSvPowerFlowQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSvPowerFlow, but only if the id matches
   *
   * @param entity SvPowerFlow
   */
  protected void emitFindSvPowerFlow(SvPowerFlow entity) {
    LOGGER.info("handling emitFindSvPowerFlow");

    queryUpdateEmitter.emit(
        FindSvPowerFlowQuery.class,
        query -> query.getFilter().getSvPowerFlowId().equals(entity.getSvPowerFlowId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSvPowerFlow
   *
   * @param entity SvPowerFlow
   */
  protected void emitFindAllSvPowerFlow(SvPowerFlow entity) {
    LOGGER.info("handling emitFindAllSvPowerFlow");

    queryUpdateEmitter.emit(FindAllSvPowerFlowQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SvPowerFlowProjector.class.getName());
}
