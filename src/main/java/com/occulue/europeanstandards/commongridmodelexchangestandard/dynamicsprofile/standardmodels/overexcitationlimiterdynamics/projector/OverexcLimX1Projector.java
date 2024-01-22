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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for OverexcLimX1 as outlined for the CQRS pattern. All event handling and query
 * handling related to OverexcLimX1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by OverexcLimX1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("overexcLimX1")
@Component("overexcLimX1-projector")
public class OverexcLimX1Projector extends OverexcLimX1EntityProjector {

  // core constructor
  public OverexcLimX1Projector(
      OverexcLimX1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateOverexcLimX1Event
   */
  @EventHandler(payloadType = CreateOverexcLimX1Event.class)
  public void handle(CreateOverexcLimX1Event event) {
    LOGGER.info("handling CreateOverexcLimX1Event - " + event);
    OverexcLimX1 entity = new OverexcLimX1();
    entity.setOverexcLimX1Id(event.getOverexcLimX1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UpdateOverexcLimX1Event
   */
  @EventHandler(payloadType = UpdateOverexcLimX1Event.class)
  public void handle(UpdateOverexcLimX1Event event) {
    LOGGER.info("handling UpdateOverexcLimX1Event - " + event);

    OverexcLimX1 entity = new OverexcLimX1();
    entity.setOverexcLimX1Id(event.getOverexcLimX1Id());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setEfd3(event.getEfd3());
    entity.setEfddes(event.getEfddes());
    entity.setEfdrated(event.getEfdrated());
    entity.setKmx(event.getKmx());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setVlow(event.getVlow());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event DeleteOverexcLimX1Event
   */
  @EventHandler(payloadType = DeleteOverexcLimX1Event.class)
  public void handle(DeleteOverexcLimX1Event event) {
    LOGGER.info("handling DeleteOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    OverexcLimX1 entity = delete(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignEfd1ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignEfd1ToOverexcLimX1Event.class)
  public void handle(AssignEfd1ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignEfd1ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignEfd1(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignEfd1FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignEfd1FromOverexcLimX1Event.class)
  public void handle(UnAssignEfd1FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignEfd1FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignEfd1(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignEfd2ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignEfd2ToOverexcLimX1Event.class)
  public void handle(AssignEfd2ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignEfd2ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignEfd2(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignEfd2FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignEfd2FromOverexcLimX1Event.class)
  public void handle(UnAssignEfd2FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignEfd2FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignEfd2(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignEfd3ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignEfd3ToOverexcLimX1Event.class)
  public void handle(AssignEfd3ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignEfd3ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignEfd3(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignEfd3FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignEfd3FromOverexcLimX1Event.class)
  public void handle(UnAssignEfd3FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignEfd3FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignEfd3(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignEfddesToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignEfddesToOverexcLimX1Event.class)
  public void handle(AssignEfddesToOverexcLimX1Event event) {
    LOGGER.info("handling AssignEfddesToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignEfddes(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignEfddesFromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignEfddesFromOverexcLimX1Event.class)
  public void handle(UnAssignEfddesFromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignEfddesFromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignEfddes(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignEfdratedToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignEfdratedToOverexcLimX1Event.class)
  public void handle(AssignEfdratedToOverexcLimX1Event event) {
    LOGGER.info("handling AssignEfdratedToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignEfdrated(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignEfdratedFromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignEfdratedFromOverexcLimX1Event.class)
  public void handle(UnAssignEfdratedFromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignEfdratedFromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignEfdrated(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignKmxToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignKmxToOverexcLimX1Event.class)
  public void handle(AssignKmxToOverexcLimX1Event event) {
    LOGGER.info("handling AssignKmxToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignKmx(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignKmxFromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignKmxFromOverexcLimX1Event.class)
  public void handle(UnAssignKmxFromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignKmxFromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignKmx(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignT1ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignT1ToOverexcLimX1Event.class)
  public void handle(AssignT1ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignT1ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignT1(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignT1FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignT1FromOverexcLimX1Event.class)
  public void handle(UnAssignT1FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignT1FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignT1(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignT2ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignT2ToOverexcLimX1Event.class)
  public void handle(AssignT2ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignT2ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignT2(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignT2FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignT2FromOverexcLimX1Event.class)
  public void handle(UnAssignT2FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignT2FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignT2(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignT3ToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignT3ToOverexcLimX1Event.class)
  public void handle(AssignT3ToOverexcLimX1Event event) {
    LOGGER.info("handling AssignT3ToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignT3(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignT3FromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignT3FromOverexcLimX1Event.class)
  public void handle(UnAssignT3FromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignT3FromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignT3(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event AssignVlowToOverexcLimX1Event
   */
  @EventHandler(payloadType = AssignVlowToOverexcLimX1Event.class)
  public void handle(AssignVlowToOverexcLimX1Event event) {
    LOGGER.info("handling AssignVlowToOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX1 entity = assignVlow(event.getOverexcLimX1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /*
   * @param	event UnAssignVlowFromOverexcLimX1Event
   */
  @EventHandler(payloadType = UnAssignVlowFromOverexcLimX1Event.class)
  public void handle(UnAssignVlowFromOverexcLimX1Event event) {
    LOGGER.info("handling UnAssignVlowFromOverexcLimX1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX1 entity = unAssignVlow(event.getOverexcLimX1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX1(entity);
  }

  /**
   * Method to retrieve the OverexcLimX1 via an OverexcLimX1PrimaryKey.
   *
   * @param id Long
   * @return OverexcLimX1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public OverexcLimX1 handle(FindOverexcLimX1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getOverexcLimX1Id());
  }

  /**
   * Method to retrieve a collection of all OverexcLimX1s
   *
   * @param query FindAllOverexcLimX1Query
   * @return List<OverexcLimX1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<OverexcLimX1> handle(FindAllOverexcLimX1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindOverexcLimX1, but only if the id matches
   *
   * @param entity OverexcLimX1
   */
  protected void emitFindOverexcLimX1(OverexcLimX1 entity) {
    LOGGER.info("handling emitFindOverexcLimX1");

    queryUpdateEmitter.emit(
        FindOverexcLimX1Query.class,
        query -> query.getFilter().getOverexcLimX1Id().equals(entity.getOverexcLimX1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllOverexcLimX1
   *
   * @param entity OverexcLimX1
   */
  protected void emitFindAllOverexcLimX1(OverexcLimX1 entity) {
    LOGGER.info("handling emitFindAllOverexcLimX1");

    queryUpdateEmitter.emit(FindAllOverexcLimX1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(OverexcLimX1Projector.class.getName());
}
