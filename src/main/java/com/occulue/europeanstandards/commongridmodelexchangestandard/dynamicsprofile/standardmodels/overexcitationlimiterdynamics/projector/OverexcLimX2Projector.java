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
 * Projector for OverexcLimX2 as outlined for the CQRS pattern. All event handling and query
 * handling related to OverexcLimX2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by OverexcLimX2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("overexcLimX2")
@Component("overexcLimX2-projector")
public class OverexcLimX2Projector extends OverexcLimX2EntityProjector {

  // core constructor
  public OverexcLimX2Projector(
      OverexcLimX2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateOverexcLimX2Event
   */
  @EventHandler(payloadType = CreateOverexcLimX2Event.class)
  public void handle(CreateOverexcLimX2Event event) {
    LOGGER.info("handling CreateOverexcLimX2Event - " + event);
    OverexcLimX2 entity = new OverexcLimX2();
    entity.setOverexcLimX2Id(event.getOverexcLimX2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UpdateOverexcLimX2Event
   */
  @EventHandler(payloadType = UpdateOverexcLimX2Event.class)
  public void handle(UpdateOverexcLimX2Event event) {
    LOGGER.info("handling UpdateOverexcLimX2Event - " + event);

    OverexcLimX2 entity = new OverexcLimX2();
    entity.setOverexcLimX2Id(event.getOverexcLimX2Id());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setEfd3(event.getEfd3());
    entity.setEfddes(event.getEfddes());
    entity.setEfdrated(event.getEfdrated());
    entity.setKmx(event.getKmx());
    entity.setM(event.getM());
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
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event DeleteOverexcLimX2Event
   */
  @EventHandler(payloadType = DeleteOverexcLimX2Event.class)
  public void handle(DeleteOverexcLimX2Event event) {
    LOGGER.info("handling DeleteOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    OverexcLimX2 entity = delete(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignEfd1ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignEfd1ToOverexcLimX2Event.class)
  public void handle(AssignEfd1ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignEfd1ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignEfd1(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignEfd1FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignEfd1FromOverexcLimX2Event.class)
  public void handle(UnAssignEfd1FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignEfd1FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignEfd1(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignEfd2ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignEfd2ToOverexcLimX2Event.class)
  public void handle(AssignEfd2ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignEfd2ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignEfd2(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignEfd2FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignEfd2FromOverexcLimX2Event.class)
  public void handle(UnAssignEfd2FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignEfd2FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignEfd2(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignEfd3ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignEfd3ToOverexcLimX2Event.class)
  public void handle(AssignEfd3ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignEfd3ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignEfd3(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignEfd3FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignEfd3FromOverexcLimX2Event.class)
  public void handle(UnAssignEfd3FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignEfd3FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignEfd3(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignEfddesToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignEfddesToOverexcLimX2Event.class)
  public void handle(AssignEfddesToOverexcLimX2Event event) {
    LOGGER.info("handling AssignEfddesToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignEfddes(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignEfddesFromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignEfddesFromOverexcLimX2Event.class)
  public void handle(UnAssignEfddesFromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignEfddesFromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignEfddes(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignEfdratedToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignEfdratedToOverexcLimX2Event.class)
  public void handle(AssignEfdratedToOverexcLimX2Event event) {
    LOGGER.info("handling AssignEfdratedToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignEfdrated(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignEfdratedFromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignEfdratedFromOverexcLimX2Event.class)
  public void handle(UnAssignEfdratedFromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignEfdratedFromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignEfdrated(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignKmxToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignKmxToOverexcLimX2Event.class)
  public void handle(AssignKmxToOverexcLimX2Event event) {
    LOGGER.info("handling AssignKmxToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignKmx(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignKmxFromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignKmxFromOverexcLimX2Event.class)
  public void handle(UnAssignKmxFromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignKmxFromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignKmx(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignMToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignMToOverexcLimX2Event.class)
  public void handle(AssignMToOverexcLimX2Event event) {
    LOGGER.info("handling AssignMToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignM(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignMFromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignMFromOverexcLimX2Event.class)
  public void handle(UnAssignMFromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignMFromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignM(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignT1ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignT1ToOverexcLimX2Event.class)
  public void handle(AssignT1ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignT1ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignT1(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignT1FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignT1FromOverexcLimX2Event.class)
  public void handle(UnAssignT1FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignT1FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignT1(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignT2ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignT2ToOverexcLimX2Event.class)
  public void handle(AssignT2ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignT2ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignT2(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignT2FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignT2FromOverexcLimX2Event.class)
  public void handle(UnAssignT2FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignT2FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignT2(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignT3ToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignT3ToOverexcLimX2Event.class)
  public void handle(AssignT3ToOverexcLimX2Event event) {
    LOGGER.info("handling AssignT3ToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignT3(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignT3FromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignT3FromOverexcLimX2Event.class)
  public void handle(UnAssignT3FromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignT3FromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignT3(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event AssignVlowToOverexcLimX2Event
   */
  @EventHandler(payloadType = AssignVlowToOverexcLimX2Event.class)
  public void handle(AssignVlowToOverexcLimX2Event event) {
    LOGGER.info("handling AssignVlowToOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    OverexcLimX2 entity = assignVlow(event.getOverexcLimX2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /*
   * @param	event UnAssignVlowFromOverexcLimX2Event
   */
  @EventHandler(payloadType = UnAssignVlowFromOverexcLimX2Event.class)
  public void handle(UnAssignVlowFromOverexcLimX2Event event) {
    LOGGER.info("handling UnAssignVlowFromOverexcLimX2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    OverexcLimX2 entity = unAssignVlow(event.getOverexcLimX2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindOverexcLimX2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllOverexcLimX2(entity);
  }

  /**
   * Method to retrieve the OverexcLimX2 via an OverexcLimX2PrimaryKey.
   *
   * @param id Long
   * @return OverexcLimX2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public OverexcLimX2 handle(FindOverexcLimX2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getOverexcLimX2Id());
  }

  /**
   * Method to retrieve a collection of all OverexcLimX2s
   *
   * @param query FindAllOverexcLimX2Query
   * @return List<OverexcLimX2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<OverexcLimX2> handle(FindAllOverexcLimX2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindOverexcLimX2, but only if the id matches
   *
   * @param entity OverexcLimX2
   */
  protected void emitFindOverexcLimX2(OverexcLimX2 entity) {
    LOGGER.info("handling emitFindOverexcLimX2");

    queryUpdateEmitter.emit(
        FindOverexcLimX2Query.class,
        query -> query.getFilter().getOverexcLimX2Id().equals(entity.getOverexcLimX2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllOverexcLimX2
   *
   * @param entity OverexcLimX2
   */
  protected void emitFindAllOverexcLimX2(OverexcLimX2 entity) {
    LOGGER.info("handling emitFindAllOverexcLimX2");

    queryUpdateEmitter.emit(FindAllOverexcLimX2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(OverexcLimX2Projector.class.getName());
}
