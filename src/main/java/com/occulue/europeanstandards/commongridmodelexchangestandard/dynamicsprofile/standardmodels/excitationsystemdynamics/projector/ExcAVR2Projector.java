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
 * Projector for ExcAVR2 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAVR2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAVR2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAVR2")
@Component("excAVR2-projector")
public class ExcAVR2Projector extends ExcAVR2EntityProjector {

  // core constructor
  public ExcAVR2Projector(ExcAVR2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAVR2Event
   */
  @EventHandler(payloadType = CreateExcAVR2Event.class)
  public void handle(CreateExcAVR2Event event) {
    LOGGER.info("handling CreateExcAVR2Event - " + event);
    ExcAVR2 entity = new ExcAVR2();
    entity.setExcAVR2Id(event.getExcAVR2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UpdateExcAVR2Event
   */
  @EventHandler(payloadType = UpdateExcAVR2Event.class)
  public void handle(UpdateExcAVR2Event event) {
    LOGGER.info("handling UpdateExcAVR2Event - " + event);

    ExcAVR2 entity = new ExcAVR2();
    entity.setExcAVR2Id(event.getExcAVR2Id());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setKa(event.getKa());
    entity.setKf(event.getKf());
    entity.setSe1(event.getSe1());
    entity.setSe2(event.getSe2());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTe(event.getTe());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setVrmn(event.getVrmn());
    entity.setVrmx(event.getVrmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event DeleteExcAVR2Event
   */
  @EventHandler(payloadType = DeleteExcAVR2Event.class)
  public void handle(DeleteExcAVR2Event event) {
    LOGGER.info("handling DeleteExcAVR2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAVR2 entity = delete(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignE1ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignE1ToExcAVR2Event.class)
  public void handle(AssignE1ToExcAVR2Event event) {
    LOGGER.info("handling AssignE1ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignE1(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignE1FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignE1FromExcAVR2Event.class)
  public void handle(UnAssignE1FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignE1FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignE1(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignE2ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignE2ToExcAVR2Event.class)
  public void handle(AssignE2ToExcAVR2Event event) {
    LOGGER.info("handling AssignE2ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignE2(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignE2FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignE2FromExcAVR2Event.class)
  public void handle(UnAssignE2FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignE2FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignE2(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignKaToExcAVR2Event
   */
  @EventHandler(payloadType = AssignKaToExcAVR2Event.class)
  public void handle(AssignKaToExcAVR2Event event) {
    LOGGER.info("handling AssignKaToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignKa(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignKaFromExcAVR2Event.class)
  public void handle(UnAssignKaFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignKaFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignKa(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignKfToExcAVR2Event
   */
  @EventHandler(payloadType = AssignKfToExcAVR2Event.class)
  public void handle(AssignKfToExcAVR2Event event) {
    LOGGER.info("handling AssignKfToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignKf(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignKfFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignKfFromExcAVR2Event.class)
  public void handle(UnAssignKfFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignKfFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignKf(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignSe1ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignSe1ToExcAVR2Event.class)
  public void handle(AssignSe1ToExcAVR2Event event) {
    LOGGER.info("handling AssignSe1ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignSe1(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignSe1FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignSe1FromExcAVR2Event.class)
  public void handle(UnAssignSe1FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignSe1FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignSe1(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignSe2ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignSe2ToExcAVR2Event.class)
  public void handle(AssignSe2ToExcAVR2Event event) {
    LOGGER.info("handling AssignSe2ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignSe2(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignSe2FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignSe2FromExcAVR2Event.class)
  public void handle(UnAssignSe2FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignSe2FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignSe2(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignTaToExcAVR2Event
   */
  @EventHandler(payloadType = AssignTaToExcAVR2Event.class)
  public void handle(AssignTaToExcAVR2Event event) {
    LOGGER.info("handling AssignTaToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignTa(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignTaFromExcAVR2Event.class)
  public void handle(UnAssignTaFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignTaFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignTa(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignTbToExcAVR2Event
   */
  @EventHandler(payloadType = AssignTbToExcAVR2Event.class)
  public void handle(AssignTbToExcAVR2Event event) {
    LOGGER.info("handling AssignTbToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignTb(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignTbFromExcAVR2Event.class)
  public void handle(UnAssignTbFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignTbFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignTb(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignTeToExcAVR2Event
   */
  @EventHandler(payloadType = AssignTeToExcAVR2Event.class)
  public void handle(AssignTeToExcAVR2Event event) {
    LOGGER.info("handling AssignTeToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignTe(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignTeFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignTeFromExcAVR2Event.class)
  public void handle(UnAssignTeFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignTeFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignTe(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignTf1ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignTf1ToExcAVR2Event.class)
  public void handle(AssignTf1ToExcAVR2Event event) {
    LOGGER.info("handling AssignTf1ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignTf1(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignTf1FromExcAVR2Event.class)
  public void handle(UnAssignTf1FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignTf1FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignTf1(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignTf2ToExcAVR2Event
   */
  @EventHandler(payloadType = AssignTf2ToExcAVR2Event.class)
  public void handle(AssignTf2ToExcAVR2Event event) {
    LOGGER.info("handling AssignTf2ToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignTf2(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignTf2FromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignTf2FromExcAVR2Event.class)
  public void handle(UnAssignTf2FromExcAVR2Event event) {
    LOGGER.info("handling UnAssignTf2FromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignTf2(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignVrmnToExcAVR2Event
   */
  @EventHandler(payloadType = AssignVrmnToExcAVR2Event.class)
  public void handle(AssignVrmnToExcAVR2Event event) {
    LOGGER.info("handling AssignVrmnToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignVrmn(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignVrmnFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignVrmnFromExcAVR2Event.class)
  public void handle(UnAssignVrmnFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignVrmnFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignVrmn(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event AssignVrmxToExcAVR2Event
   */
  @EventHandler(payloadType = AssignVrmxToExcAVR2Event.class)
  public void handle(AssignVrmxToExcAVR2Event event) {
    LOGGER.info("handling AssignVrmxToExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR2 entity = assignVrmx(event.getExcAVR2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /*
   * @param	event UnAssignVrmxFromExcAVR2Event
   */
  @EventHandler(payloadType = UnAssignVrmxFromExcAVR2Event.class)
  public void handle(UnAssignVrmxFromExcAVR2Event event) {
    LOGGER.info("handling UnAssignVrmxFromExcAVR2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR2 entity = unAssignVrmx(event.getExcAVR2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR2(entity);
  }

  /**
   * Method to retrieve the ExcAVR2 via an ExcAVR2PrimaryKey.
   *
   * @param id Long
   * @return ExcAVR2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAVR2 handle(FindExcAVR2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAVR2Id());
  }

  /**
   * Method to retrieve a collection of all ExcAVR2s
   *
   * @param query FindAllExcAVR2Query
   * @return List<ExcAVR2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAVR2> handle(FindAllExcAVR2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAVR2, but only if the id matches
   *
   * @param entity ExcAVR2
   */
  protected void emitFindExcAVR2(ExcAVR2 entity) {
    LOGGER.info("handling emitFindExcAVR2");

    queryUpdateEmitter.emit(
        FindExcAVR2Query.class,
        query -> query.getFilter().getExcAVR2Id().equals(entity.getExcAVR2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAVR2
   *
   * @param entity ExcAVR2
   */
  protected void emitFindAllExcAVR2(ExcAVR2 entity) {
    LOGGER.info("handling emitFindAllExcAVR2");

    queryUpdateEmitter.emit(FindAllExcAVR2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR2Projector.class.getName());
}
