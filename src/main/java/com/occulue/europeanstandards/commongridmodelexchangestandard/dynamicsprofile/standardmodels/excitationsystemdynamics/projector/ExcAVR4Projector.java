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
 * Projector for ExcAVR4 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAVR4 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAVR4Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAVR4")
@Component("excAVR4-projector")
public class ExcAVR4Projector extends ExcAVR4EntityProjector {

  // core constructor
  public ExcAVR4Projector(ExcAVR4Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAVR4Event
   */
  @EventHandler(payloadType = CreateExcAVR4Event.class)
  public void handle(CreateExcAVR4Event event) {
    LOGGER.info("handling CreateExcAVR4Event - " + event);
    ExcAVR4 entity = new ExcAVR4();
    entity.setExcAVR4Id(event.getExcAVR4Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UpdateExcAVR4Event
   */
  @EventHandler(payloadType = UpdateExcAVR4Event.class)
  public void handle(UpdateExcAVR4Event event) {
    LOGGER.info("handling UpdateExcAVR4Event - " + event);

    ExcAVR4 entity = new ExcAVR4();
    entity.setExcAVR4Id(event.getExcAVR4Id());
    entity.setImul(event.getImul());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKif(event.getKif());
    entity.setT1(event.getT1());
    entity.setT1if(event.getT1if());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setTif(event.getTif());
    entity.setVfmn(event.getVfmn());
    entity.setVfmx(event.getVfmx());
    entity.setVrmn(event.getVrmn());
    entity.setVrmx(event.getVrmx());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event DeleteExcAVR4Event
   */
  @EventHandler(payloadType = DeleteExcAVR4Event.class)
  public void handle(DeleteExcAVR4Event event) {
    LOGGER.info("handling DeleteExcAVR4Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAVR4 entity = delete(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignImulToExcAVR4Event
   */
  @EventHandler(payloadType = AssignImulToExcAVR4Event.class)
  public void handle(AssignImulToExcAVR4Event event) {
    LOGGER.info("handling AssignImulToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignImul(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignImulFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignImulFromExcAVR4Event.class)
  public void handle(UnAssignImulFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignImulFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignImul(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignKaToExcAVR4Event
   */
  @EventHandler(payloadType = AssignKaToExcAVR4Event.class)
  public void handle(AssignKaToExcAVR4Event event) {
    LOGGER.info("handling AssignKaToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignKa(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignKaFromExcAVR4Event.class)
  public void handle(UnAssignKaFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignKaFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignKa(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignKeToExcAVR4Event
   */
  @EventHandler(payloadType = AssignKeToExcAVR4Event.class)
  public void handle(AssignKeToExcAVR4Event event) {
    LOGGER.info("handling AssignKeToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignKe(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignKeFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignKeFromExcAVR4Event.class)
  public void handle(UnAssignKeFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignKeFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignKe(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignKifToExcAVR4Event
   */
  @EventHandler(payloadType = AssignKifToExcAVR4Event.class)
  public void handle(AssignKifToExcAVR4Event event) {
    LOGGER.info("handling AssignKifToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignKif(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignKifFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignKifFromExcAVR4Event.class)
  public void handle(UnAssignKifFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignKifFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignKif(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignT1ToExcAVR4Event
   */
  @EventHandler(payloadType = AssignT1ToExcAVR4Event.class)
  public void handle(AssignT1ToExcAVR4Event event) {
    LOGGER.info("handling AssignT1ToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignT1(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignT1FromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignT1FromExcAVR4Event.class)
  public void handle(UnAssignT1FromExcAVR4Event event) {
    LOGGER.info("handling UnAssignT1FromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignT1(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignT1ifToExcAVR4Event
   */
  @EventHandler(payloadType = AssignT1ifToExcAVR4Event.class)
  public void handle(AssignT1ifToExcAVR4Event event) {
    LOGGER.info("handling AssignT1ifToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignT1if(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignT1ifFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignT1ifFromExcAVR4Event.class)
  public void handle(UnAssignT1ifFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignT1ifFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignT1if(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignT2ToExcAVR4Event
   */
  @EventHandler(payloadType = AssignT2ToExcAVR4Event.class)
  public void handle(AssignT2ToExcAVR4Event event) {
    LOGGER.info("handling AssignT2ToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignT2(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignT2FromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignT2FromExcAVR4Event.class)
  public void handle(UnAssignT2FromExcAVR4Event event) {
    LOGGER.info("handling UnAssignT2FromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignT2(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignT3ToExcAVR4Event
   */
  @EventHandler(payloadType = AssignT3ToExcAVR4Event.class)
  public void handle(AssignT3ToExcAVR4Event event) {
    LOGGER.info("handling AssignT3ToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignT3(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignT3FromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignT3FromExcAVR4Event.class)
  public void handle(UnAssignT3FromExcAVR4Event event) {
    LOGGER.info("handling UnAssignT3FromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignT3(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignT4ToExcAVR4Event
   */
  @EventHandler(payloadType = AssignT4ToExcAVR4Event.class)
  public void handle(AssignT4ToExcAVR4Event event) {
    LOGGER.info("handling AssignT4ToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignT4(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignT4FromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignT4FromExcAVR4Event.class)
  public void handle(UnAssignT4FromExcAVR4Event event) {
    LOGGER.info("handling UnAssignT4FromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignT4(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignTifToExcAVR4Event
   */
  @EventHandler(payloadType = AssignTifToExcAVR4Event.class)
  public void handle(AssignTifToExcAVR4Event event) {
    LOGGER.info("handling AssignTifToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignTif(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignTifFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignTifFromExcAVR4Event.class)
  public void handle(UnAssignTifFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignTifFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignTif(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignVfmnToExcAVR4Event
   */
  @EventHandler(payloadType = AssignVfmnToExcAVR4Event.class)
  public void handle(AssignVfmnToExcAVR4Event event) {
    LOGGER.info("handling AssignVfmnToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignVfmn(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignVfmnFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignVfmnFromExcAVR4Event.class)
  public void handle(UnAssignVfmnFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignVfmnFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignVfmn(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignVfmxToExcAVR4Event
   */
  @EventHandler(payloadType = AssignVfmxToExcAVR4Event.class)
  public void handle(AssignVfmxToExcAVR4Event event) {
    LOGGER.info("handling AssignVfmxToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignVfmx(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignVfmxFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignVfmxFromExcAVR4Event.class)
  public void handle(UnAssignVfmxFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignVfmxFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignVfmx(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignVrmnToExcAVR4Event
   */
  @EventHandler(payloadType = AssignVrmnToExcAVR4Event.class)
  public void handle(AssignVrmnToExcAVR4Event event) {
    LOGGER.info("handling AssignVrmnToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignVrmn(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignVrmnFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignVrmnFromExcAVR4Event.class)
  public void handle(UnAssignVrmnFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignVrmnFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignVrmn(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event AssignVrmxToExcAVR4Event
   */
  @EventHandler(payloadType = AssignVrmxToExcAVR4Event.class)
  public void handle(AssignVrmxToExcAVR4Event event) {
    LOGGER.info("handling AssignVrmxToExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAVR4 entity = assignVrmx(event.getExcAVR4Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /*
   * @param	event UnAssignVrmxFromExcAVR4Event
   */
  @EventHandler(payloadType = UnAssignVrmxFromExcAVR4Event.class)
  public void handle(UnAssignVrmxFromExcAVR4Event event) {
    LOGGER.info("handling UnAssignVrmxFromExcAVR4Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAVR4 entity = unAssignVrmx(event.getExcAVR4Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAVR4(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAVR4(entity);
  }

  /**
   * Method to retrieve the ExcAVR4 via an ExcAVR4PrimaryKey.
   *
   * @param id Long
   * @return ExcAVR4
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAVR4 handle(FindExcAVR4Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAVR4Id());
  }

  /**
   * Method to retrieve a collection of all ExcAVR4s
   *
   * @param query FindAllExcAVR4Query
   * @return List<ExcAVR4>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAVR4> handle(FindAllExcAVR4Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAVR4, but only if the id matches
   *
   * @param entity ExcAVR4
   */
  protected void emitFindExcAVR4(ExcAVR4 entity) {
    LOGGER.info("handling emitFindExcAVR4");

    queryUpdateEmitter.emit(
        FindExcAVR4Query.class,
        query -> query.getFilter().getExcAVR4Id().equals(entity.getExcAVR4Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAVR4
   *
   * @param entity ExcAVR4
   */
  protected void emitFindAllExcAVR4(ExcAVR4 entity) {
    LOGGER.info("handling emitFindAllExcAVR4");

    queryUpdateEmitter.emit(FindAllExcAVR4Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAVR4Projector.class.getName());
}
