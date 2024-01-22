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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcBBC as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcBBC are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcBBCAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excBBC")
@Component("excBBC-projector")
public class ExcBBCProjector extends ExcBBCEntityProjector {

  // core constructor
  public ExcBBCProjector(ExcBBCRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcBBCEvent
   */
  @EventHandler(payloadType = CreateExcBBCEvent.class)
  public void handle(CreateExcBBCEvent event) {
    LOGGER.info("handling CreateExcBBCEvent - " + event);
    ExcBBC entity = new ExcBBC();
    entity.setExcBBCId(event.getExcBBCId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UpdateExcBBCEvent
   */
  @EventHandler(payloadType = UpdateExcBBCEvent.class)
  public void handle(UpdateExcBBCEvent event) {
    LOGGER.info("handling UpdateExcBBCEvent - " + event);

    ExcBBC entity = new ExcBBC();
    entity.setExcBBCId(event.getExcBBCId());
    entity.setEfdmax(event.getEfdmax());
    entity.setEfdmin(event.getEfdmin());
    entity.setK(event.getK());
    entity.setSwitchIt(event.getSwitchIt());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setXe(event.getXe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event DeleteExcBBCEvent
   */
  @EventHandler(payloadType = DeleteExcBBCEvent.class)
  public void handle(DeleteExcBBCEvent event) {
    LOGGER.info("handling DeleteExcBBCEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcBBC entity = delete(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcBBCEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcBBCEvent.class)
  public void handle(AssignEfdmaxToExcBBCEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignEfdmax(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcBBCEvent.class)
  public void handle(UnAssignEfdmaxFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignEfdmax(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignEfdminToExcBBCEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcBBCEvent.class)
  public void handle(AssignEfdminToExcBBCEvent event) {
    LOGGER.info("handling AssignEfdminToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignEfdmin(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcBBCEvent.class)
  public void handle(UnAssignEfdminFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignEfdmin(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignKToExcBBCEvent
   */
  @EventHandler(payloadType = AssignKToExcBBCEvent.class)
  public void handle(AssignKToExcBBCEvent event) {
    LOGGER.info("handling AssignKToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignK(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignKFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignKFromExcBBCEvent.class)
  public void handle(UnAssignKFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignKFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignK(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignSwitchItToExcBBCEvent
   */
  @EventHandler(payloadType = AssignSwitchItToExcBBCEvent.class)
  public void handle(AssignSwitchItToExcBBCEvent event) {
    LOGGER.info("handling AssignSwitchItToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignSwitchIt(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignSwitchItFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignSwitchItFromExcBBCEvent.class)
  public void handle(UnAssignSwitchItFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignSwitchItFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignSwitchIt(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignT1ToExcBBCEvent
   */
  @EventHandler(payloadType = AssignT1ToExcBBCEvent.class)
  public void handle(AssignT1ToExcBBCEvent event) {
    LOGGER.info("handling AssignT1ToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignT1(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignT1FromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignT1FromExcBBCEvent.class)
  public void handle(UnAssignT1FromExcBBCEvent event) {
    LOGGER.info("handling UnAssignT1FromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignT1(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignT2ToExcBBCEvent
   */
  @EventHandler(payloadType = AssignT2ToExcBBCEvent.class)
  public void handle(AssignT2ToExcBBCEvent event) {
    LOGGER.info("handling AssignT2ToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignT2(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignT2FromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignT2FromExcBBCEvent.class)
  public void handle(UnAssignT2FromExcBBCEvent event) {
    LOGGER.info("handling UnAssignT2FromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignT2(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignT3ToExcBBCEvent
   */
  @EventHandler(payloadType = AssignT3ToExcBBCEvent.class)
  public void handle(AssignT3ToExcBBCEvent event) {
    LOGGER.info("handling AssignT3ToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignT3(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignT3FromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignT3FromExcBBCEvent.class)
  public void handle(UnAssignT3FromExcBBCEvent event) {
    LOGGER.info("handling UnAssignT3FromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignT3(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignT4ToExcBBCEvent
   */
  @EventHandler(payloadType = AssignT4ToExcBBCEvent.class)
  public void handle(AssignT4ToExcBBCEvent event) {
    LOGGER.info("handling AssignT4ToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignT4(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignT4FromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignT4FromExcBBCEvent.class)
  public void handle(UnAssignT4FromExcBBCEvent event) {
    LOGGER.info("handling UnAssignT4FromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignT4(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignVrmaxToExcBBCEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcBBCEvent.class)
  public void handle(AssignVrmaxToExcBBCEvent event) {
    LOGGER.info("handling AssignVrmaxToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignVrmax(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcBBCEvent.class)
  public void handle(UnAssignVrmaxFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignVrmax(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignVrminToExcBBCEvent
   */
  @EventHandler(payloadType = AssignVrminToExcBBCEvent.class)
  public void handle(AssignVrminToExcBBCEvent event) {
    LOGGER.info("handling AssignVrminToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignVrmin(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcBBCEvent.class)
  public void handle(UnAssignVrminFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignVrmin(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event AssignXeToExcBBCEvent
   */
  @EventHandler(payloadType = AssignXeToExcBBCEvent.class)
  public void handle(AssignXeToExcBBCEvent event) {
    LOGGER.info("handling AssignXeToExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcBBC entity = assignXe(event.getExcBBCId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /*
   * @param	event UnAssignXeFromExcBBCEvent
   */
  @EventHandler(payloadType = UnAssignXeFromExcBBCEvent.class)
  public void handle(UnAssignXeFromExcBBCEvent event) {
    LOGGER.info("handling UnAssignXeFromExcBBCEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcBBC entity = unAssignXe(event.getExcBBCId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcBBC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcBBC(entity);
  }

  /**
   * Method to retrieve the ExcBBC via an ExcBBCPrimaryKey.
   *
   * @param id Long
   * @return ExcBBC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcBBC handle(FindExcBBCQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcBBCId());
  }

  /**
   * Method to retrieve a collection of all ExcBBCs
   *
   * @param query FindAllExcBBCQuery
   * @return List<ExcBBC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcBBC> handle(FindAllExcBBCQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcBBC, but only if the id matches
   *
   * @param entity ExcBBC
   */
  protected void emitFindExcBBC(ExcBBC entity) {
    LOGGER.info("handling emitFindExcBBC");

    queryUpdateEmitter.emit(
        FindExcBBCQuery.class,
        query -> query.getFilter().getExcBBCId().equals(entity.getExcBBCId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcBBC
   *
   * @param entity ExcBBC
   */
  protected void emitFindAllExcBBC(ExcBBC entity) {
    LOGGER.info("handling emitFindAllExcBBC");

    queryUpdateEmitter.emit(FindAllExcBBCQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcBBCProjector.class.getName());
}
