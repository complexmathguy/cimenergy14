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
 * Projector for ExcAVR1 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAVR1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAVR1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAVR1")
@Component("excAVR1-projector")
public class ExcAVR1Projector extends ExcAVR1EntityProjector {

  // core constructor
  public ExcAVR1Projector(ExcAVR1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAVR1Event
   */
  @EventHandler(payloadType = CreateExcAVR1Event.class)
  public void handle(CreateExcAVR1Event event) {
    LOGGER.info("handling CreateExcAVR1Event - " + event);
    ExcAVR1 entity = new ExcAVR1();
    entity.setExcAVR1Id(event.getExcAVR1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UpdateExcAVR1Event
   */
  @EventHandler(payloadType = UpdateExcAVR1Event.class)
  public void handle(UpdateExcAVR1Event event) {
    LOGGER.info("handling UpdateExcAVR1Event - " + event);

    ExcAVR1 entity = new ExcAVR1();
    entity.setExcAVR1Id(event.getExcAVR1Id());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setKa(event.getKa());
    entity.setKf(event.getKf());
    entity.setSe1(event.getSe1());
    entity.setSe2(event.getSe2());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setVrmn(event.getVrmn());
    entity.setVrmx(event.getVrmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event DeleteExcAVR1Event
   */
  @EventHandler(payloadType = DeleteExcAVR1Event.class)
  public void handle(DeleteExcAVR1Event event) {
    LOGGER.info("handling DeleteExcAVR1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAVR1 entity = delete(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignE1ToExcAVR1Event
   */
  @EventHandler(payloadType = AssignE1ToExcAVR1Event.class)
  public void handle(AssignE1ToExcAVR1Event event) {
    LOGGER.info("handling AssignE1ToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignE1(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignE1FromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignE1FromExcAVR1Event.class)
  public void handle(UnAssignE1FromExcAVR1Event event) {
    LOGGER.info("handling UnAssignE1FromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignE1(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignE2ToExcAVR1Event
   */
  @EventHandler(payloadType = AssignE2ToExcAVR1Event.class)
  public void handle(AssignE2ToExcAVR1Event event) {
    LOGGER.info("handling AssignE2ToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignE2(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignE2FromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignE2FromExcAVR1Event.class)
  public void handle(UnAssignE2FromExcAVR1Event event) {
    LOGGER.info("handling UnAssignE2FromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignE2(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignKaToExcAVR1Event
   */
  @EventHandler(payloadType = AssignKaToExcAVR1Event.class)
  public void handle(AssignKaToExcAVR1Event event) {
    LOGGER.info("handling AssignKaToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignKa(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignKaFromExcAVR1Event.class)
  public void handle(UnAssignKaFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignKaFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignKa(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignKfToExcAVR1Event
   */
  @EventHandler(payloadType = AssignKfToExcAVR1Event.class)
  public void handle(AssignKfToExcAVR1Event event) {
    LOGGER.info("handling AssignKfToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignKf(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignKfFromExcAVR1Event.class)
  public void handle(UnAssignKfFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignKfFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignKf(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignSe1ToExcAVR1Event
   */
  @EventHandler(payloadType = AssignSe1ToExcAVR1Event.class)
  public void handle(AssignSe1ToExcAVR1Event event) {
    LOGGER.info("handling AssignSe1ToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignSe1(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignSe1FromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignSe1FromExcAVR1Event.class)
  public void handle(UnAssignSe1FromExcAVR1Event event) {
    LOGGER.info("handling UnAssignSe1FromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignSe1(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignSe2ToExcAVR1Event
   */
  @EventHandler(payloadType = AssignSe2ToExcAVR1Event.class)
  public void handle(AssignSe2ToExcAVR1Event event) {
    LOGGER.info("handling AssignSe2ToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignSe2(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignSe2FromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignSe2FromExcAVR1Event.class)
  public void handle(UnAssignSe2FromExcAVR1Event event) {
    LOGGER.info("handling UnAssignSe2FromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignSe2(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignTaToExcAVR1Event
   */
  @EventHandler(payloadType = AssignTaToExcAVR1Event.class)
  public void handle(AssignTaToExcAVR1Event event) {
    LOGGER.info("handling AssignTaToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignTa(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignTaFromExcAVR1Event.class)
  public void handle(UnAssignTaFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignTaFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignTa(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignTbToExcAVR1Event
   */
  @EventHandler(payloadType = AssignTbToExcAVR1Event.class)
  public void handle(AssignTbToExcAVR1Event event) {
    LOGGER.info("handling AssignTbToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignTb(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignTbFromExcAVR1Event.class)
  public void handle(UnAssignTbFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignTbFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignTb(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignTeToExcAVR1Event
   */
  @EventHandler(payloadType = AssignTeToExcAVR1Event.class)
  public void handle(AssignTeToExcAVR1Event event) {
    LOGGER.info("handling AssignTeToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignTe(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignTeFromExcAVR1Event.class)
  public void handle(UnAssignTeFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignTeFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignTe(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignTfToExcAVR1Event
   */
  @EventHandler(payloadType = AssignTfToExcAVR1Event.class)
  public void handle(AssignTfToExcAVR1Event event) {
    LOGGER.info("handling AssignTfToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignTf(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignTfFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignTfFromExcAVR1Event.class)
  public void handle(UnAssignTfFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignTfFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignTf(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignVrmnToExcAVR1Event
   */
  @EventHandler(payloadType = AssignVrmnToExcAVR1Event.class)
  public void handle(AssignVrmnToExcAVR1Event event) {
    LOGGER.info("handling AssignVrmnToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignVrmn(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignVrmnFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignVrmnFromExcAVR1Event.class)
  public void handle(UnAssignVrmnFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignVrmnFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignVrmn(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event AssignVrmxToExcAVR1Event
   */
  @EventHandler(payloadType = AssignVrmxToExcAVR1Event.class)
  public void handle(AssignVrmxToExcAVR1Event event) {
    LOGGER.info("handling AssignVrmxToExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR1 entity = assignVrmx(event.getExcAVR1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /*
   * @param	event UnAssignVrmxFromExcAVR1Event
   */
  @EventHandler(payloadType = UnAssignVrmxFromExcAVR1Event.class)
  public void handle(UnAssignVrmxFromExcAVR1Event event) {
    LOGGER.info("handling UnAssignVrmxFromExcAVR1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR1 entity = unAssignVrmx(event.getExcAVR1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR1(entity);
  }

  /**
   * Method to retrieve the ExcAVR1 via an ExcAVR1PrimaryKey.
   *
   * @param id Long
   * @return ExcAVR1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAVR1 handle(FindExcAVR1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAVR1Id());
  }

  /**
   * Method to retrieve a collection of all ExcAVR1s
   *
   * @param query FindAllExcAVR1Query
   * @return List<ExcAVR1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAVR1> handle(FindAllExcAVR1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAVR1, but only if the id matches
   *
   * @param entity ExcAVR1
   */
  protected void emitFindExcAVR1(ExcAVR1 entity) {
    LOGGER.info("handling emitFindExcAVR1");

    queryUpdateEmitter.emit(
        FindExcAVR1Query.class,
        query -> query.getFilter().getExcAVR1Id().equals(entity.getExcAVR1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAVR1
   *
   * @param entity ExcAVR1
   */
  protected void emitFindAllExcAVR1(ExcAVR1 entity) {
    LOGGER.info("handling emitFindAllExcAVR1");

    queryUpdateEmitter.emit(FindAllExcAVR1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR1Projector.class.getName());
}
