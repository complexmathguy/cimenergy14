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
 * Projector for ExcAVR3 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAVR3 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAVR3Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAVR3")
@Component("excAVR3-projector")
public class ExcAVR3Projector extends ExcAVR3EntityProjector {

  // core constructor
  public ExcAVR3Projector(ExcAVR3Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAVR3Event
   */
  @EventHandler(payloadType = CreateExcAVR3Event.class)
  public void handle(CreateExcAVR3Event event) {
    LOGGER.info("handling CreateExcAVR3Event - " + event);
    ExcAVR3 entity = new ExcAVR3();
    entity.setExcAVR3Id(event.getExcAVR3Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UpdateExcAVR3Event
   */
  @EventHandler(payloadType = UpdateExcAVR3Event.class)
  public void handle(UpdateExcAVR3Event event) {
    LOGGER.info("handling UpdateExcAVR3Event - " + event);

    ExcAVR3 entity = new ExcAVR3();
    entity.setExcAVR3Id(event.getExcAVR3Id());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setKa(event.getKa());
    entity.setSe1(event.getSe1());
    entity.setSe2(event.getSe2());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setTe(event.getTe());
    entity.setVrmn(event.getVrmn());
    entity.setVrmx(event.getVrmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event DeleteExcAVR3Event
   */
  @EventHandler(payloadType = DeleteExcAVR3Event.class)
  public void handle(DeleteExcAVR3Event event) {
    LOGGER.info("handling DeleteExcAVR3Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAVR3 entity = delete(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignE1ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignE1ToExcAVR3Event.class)
  public void handle(AssignE1ToExcAVR3Event event) {
    LOGGER.info("handling AssignE1ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignE1(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignE1FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignE1FromExcAVR3Event.class)
  public void handle(UnAssignE1FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignE1FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignE1(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignE2ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignE2ToExcAVR3Event.class)
  public void handle(AssignE2ToExcAVR3Event event) {
    LOGGER.info("handling AssignE2ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignE2(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignE2FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignE2FromExcAVR3Event.class)
  public void handle(UnAssignE2FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignE2FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignE2(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignKaToExcAVR3Event
   */
  @EventHandler(payloadType = AssignKaToExcAVR3Event.class)
  public void handle(AssignKaToExcAVR3Event event) {
    LOGGER.info("handling AssignKaToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignKa(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignKaFromExcAVR3Event.class)
  public void handle(UnAssignKaFromExcAVR3Event event) {
    LOGGER.info("handling UnAssignKaFromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignKa(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignSe1ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignSe1ToExcAVR3Event.class)
  public void handle(AssignSe1ToExcAVR3Event event) {
    LOGGER.info("handling AssignSe1ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignSe1(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignSe1FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignSe1FromExcAVR3Event.class)
  public void handle(UnAssignSe1FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignSe1FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignSe1(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignSe2ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignSe2ToExcAVR3Event.class)
  public void handle(AssignSe2ToExcAVR3Event event) {
    LOGGER.info("handling AssignSe2ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignSe2(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignSe2FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignSe2FromExcAVR3Event.class)
  public void handle(UnAssignSe2FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignSe2FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignSe2(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignT1ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignT1ToExcAVR3Event.class)
  public void handle(AssignT1ToExcAVR3Event event) {
    LOGGER.info("handling AssignT1ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignT1(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignT1FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignT1FromExcAVR3Event.class)
  public void handle(UnAssignT1FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignT1FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignT1(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignT2ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignT2ToExcAVR3Event.class)
  public void handle(AssignT2ToExcAVR3Event event) {
    LOGGER.info("handling AssignT2ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignT2(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignT2FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignT2FromExcAVR3Event.class)
  public void handle(UnAssignT2FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignT2FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignT2(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignT3ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignT3ToExcAVR3Event.class)
  public void handle(AssignT3ToExcAVR3Event event) {
    LOGGER.info("handling AssignT3ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignT3(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignT3FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignT3FromExcAVR3Event.class)
  public void handle(UnAssignT3FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignT3FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignT3(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignT4ToExcAVR3Event
   */
  @EventHandler(payloadType = AssignT4ToExcAVR3Event.class)
  public void handle(AssignT4ToExcAVR3Event event) {
    LOGGER.info("handling AssignT4ToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignT4(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignT4FromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignT4FromExcAVR3Event.class)
  public void handle(UnAssignT4FromExcAVR3Event event) {
    LOGGER.info("handling UnAssignT4FromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignT4(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignTeToExcAVR3Event
   */
  @EventHandler(payloadType = AssignTeToExcAVR3Event.class)
  public void handle(AssignTeToExcAVR3Event event) {
    LOGGER.info("handling AssignTeToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignTe(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignTeFromExcAVR3Event.class)
  public void handle(UnAssignTeFromExcAVR3Event event) {
    LOGGER.info("handling UnAssignTeFromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignTe(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignVrmnToExcAVR3Event
   */
  @EventHandler(payloadType = AssignVrmnToExcAVR3Event.class)
  public void handle(AssignVrmnToExcAVR3Event event) {
    LOGGER.info("handling AssignVrmnToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignVrmn(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignVrmnFromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignVrmnFromExcAVR3Event.class)
  public void handle(UnAssignVrmnFromExcAVR3Event event) {
    LOGGER.info("handling UnAssignVrmnFromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignVrmn(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event AssignVrmxToExcAVR3Event
   */
  @EventHandler(payloadType = AssignVrmxToExcAVR3Event.class)
  public void handle(AssignVrmxToExcAVR3Event event) {
    LOGGER.info("handling AssignVrmxToExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR3 entity = assignVrmx(event.getExcAVR3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /*
   * @param	event UnAssignVrmxFromExcAVR3Event
   */
  @EventHandler(payloadType = UnAssignVrmxFromExcAVR3Event.class)
  public void handle(UnAssignVrmxFromExcAVR3Event event) {
    LOGGER.info("handling UnAssignVrmxFromExcAVR3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR3 entity = unAssignVrmx(event.getExcAVR3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR3(entity);
  }

  /**
   * Method to retrieve the ExcAVR3 via an ExcAVR3PrimaryKey.
   *
   * @param id Long
   * @return ExcAVR3
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAVR3 handle(FindExcAVR3Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAVR3Id());
  }

  /**
   * Method to retrieve a collection of all ExcAVR3s
   *
   * @param query FindAllExcAVR3Query
   * @return List<ExcAVR3>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAVR3> handle(FindAllExcAVR3Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAVR3, but only if the id matches
   *
   * @param entity ExcAVR3
   */
  protected void emitFindExcAVR3(ExcAVR3 entity) {
    LOGGER.info("handling emitFindExcAVR3");

    queryUpdateEmitter.emit(
        FindExcAVR3Query.class,
        query -> query.getFilter().getExcAVR3Id().equals(entity.getExcAVR3Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAVR3
   *
   * @param entity ExcAVR3
   */
  protected void emitFindAllExcAVR3(ExcAVR3 entity) {
    LOGGER.info("handling emitFindAllExcAVR3");

    queryUpdateEmitter.emit(FindAllExcAVR3Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR3Projector.class.getName());
}
