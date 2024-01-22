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
 * Projector for ExcDC3A1 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcDC3A1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcDC3A1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excDC3A1")
@Component("excDC3A1-projector")
public class ExcDC3A1Projector extends ExcDC3A1EntityProjector {

  // core constructor
  public ExcDC3A1Projector(ExcDC3A1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcDC3A1Event
   */
  @EventHandler(payloadType = CreateExcDC3A1Event.class)
  public void handle(CreateExcDC3A1Event event) {
    LOGGER.info("handling CreateExcDC3A1Event - " + event);
    ExcDC3A1 entity = new ExcDC3A1();
    entity.setExcDC3A1Id(event.getExcDC3A1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UpdateExcDC3A1Event
   */
  @EventHandler(payloadType = UpdateExcDC3A1Event.class)
  public void handle(UpdateExcDC3A1Event event) {
    LOGGER.info("handling UpdateExcDC3A1Event - " + event);

    ExcDC3A1 entity = new ExcDC3A1();
    entity.setExcDC3A1Id(event.getExcDC3A1Id());
    entity.setExclim(event.getExclim());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setTa(event.getTa());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setVb1max(event.getVb1max());
    entity.setVblim(event.getVblim());
    entity.setVbmax(event.getVbmax());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event DeleteExcDC3A1Event
   */
  @EventHandler(payloadType = DeleteExcDC3A1Event.class)
  public void handle(DeleteExcDC3A1Event event) {
    LOGGER.info("handling DeleteExcDC3A1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcDC3A1 entity = delete(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignExclimToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignExclimToExcDC3A1Event.class)
  public void handle(AssignExclimToExcDC3A1Event event) {
    LOGGER.info("handling AssignExclimToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignExclim(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignExclimFromExcDC3A1Event.class)
  public void handle(UnAssignExclimFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignExclimFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignExclim(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignKaToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignKaToExcDC3A1Event.class)
  public void handle(AssignKaToExcDC3A1Event event) {
    LOGGER.info("handling AssignKaToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignKa(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignKaFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignKaFromExcDC3A1Event.class)
  public void handle(UnAssignKaFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignKaFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignKa(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignKeToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignKeToExcDC3A1Event.class)
  public void handle(AssignKeToExcDC3A1Event event) {
    LOGGER.info("handling AssignKeToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignKe(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignKeFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignKeFromExcDC3A1Event.class)
  public void handle(UnAssignKeFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignKeFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignKe(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignKfToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignKfToExcDC3A1Event.class)
  public void handle(AssignKfToExcDC3A1Event event) {
    LOGGER.info("handling AssignKfToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignKf(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignKfFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignKfFromExcDC3A1Event.class)
  public void handle(UnAssignKfFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignKfFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignKf(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignKiToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignKiToExcDC3A1Event.class)
  public void handle(AssignKiToExcDC3A1Event event) {
    LOGGER.info("handling AssignKiToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignKi(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignKiFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignKiFromExcDC3A1Event.class)
  public void handle(UnAssignKiFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignKiFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignKi(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignKpToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignKpToExcDC3A1Event.class)
  public void handle(AssignKpToExcDC3A1Event event) {
    LOGGER.info("handling AssignKpToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignKp(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignKpFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignKpFromExcDC3A1Event.class)
  public void handle(UnAssignKpFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignKpFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignKp(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignTaToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignTaToExcDC3A1Event.class)
  public void handle(AssignTaToExcDC3A1Event event) {
    LOGGER.info("handling AssignTaToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignTa(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignTaFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignTaFromExcDC3A1Event.class)
  public void handle(UnAssignTaFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignTaFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignTa(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignTeToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignTeToExcDC3A1Event.class)
  public void handle(AssignTeToExcDC3A1Event event) {
    LOGGER.info("handling AssignTeToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignTe(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignTeFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignTeFromExcDC3A1Event.class)
  public void handle(UnAssignTeFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignTeFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignTe(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignTfToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignTfToExcDC3A1Event.class)
  public void handle(AssignTfToExcDC3A1Event event) {
    LOGGER.info("handling AssignTfToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignTf(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignTfFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignTfFromExcDC3A1Event.class)
  public void handle(UnAssignTfFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignTfFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignTf(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignVb1maxToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignVb1maxToExcDC3A1Event.class)
  public void handle(AssignVb1maxToExcDC3A1Event event) {
    LOGGER.info("handling AssignVb1maxToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignVb1max(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignVb1maxFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignVb1maxFromExcDC3A1Event.class)
  public void handle(UnAssignVb1maxFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignVb1maxFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignVb1max(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignVblimToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignVblimToExcDC3A1Event.class)
  public void handle(AssignVblimToExcDC3A1Event event) {
    LOGGER.info("handling AssignVblimToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignVblim(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignVblimFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignVblimFromExcDC3A1Event.class)
  public void handle(UnAssignVblimFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignVblimFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignVblim(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignVbmaxToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignVbmaxToExcDC3A1Event.class)
  public void handle(AssignVbmaxToExcDC3A1Event event) {
    LOGGER.info("handling AssignVbmaxToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignVbmax(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignVbmaxFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignVbmaxFromExcDC3A1Event.class)
  public void handle(UnAssignVbmaxFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignVbmaxFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignVbmax(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignVrmaxToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignVrmaxToExcDC3A1Event.class)
  public void handle(AssignVrmaxToExcDC3A1Event event) {
    LOGGER.info("handling AssignVrmaxToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignVrmax(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcDC3A1Event.class)
  public void handle(UnAssignVrmaxFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignVrmaxFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignVrmax(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event AssignVrminToExcDC3A1Event
   */
  @EventHandler(payloadType = AssignVrminToExcDC3A1Event.class)
  public void handle(AssignVrminToExcDC3A1Event event) {
    LOGGER.info("handling AssignVrminToExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A1 entity = assignVrmin(event.getExcDC3A1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcDC3A1Event
   */
  @EventHandler(payloadType = UnAssignVrminFromExcDC3A1Event.class)
  public void handle(UnAssignVrminFromExcDC3A1Event event) {
    LOGGER.info("handling UnAssignVrminFromExcDC3A1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A1 entity = unAssignVrmin(event.getExcDC3A1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A1(entity);
  }

  /**
   * Method to retrieve the ExcDC3A1 via an ExcDC3A1PrimaryKey.
   *
   * @param id Long
   * @return ExcDC3A1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcDC3A1 handle(FindExcDC3A1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcDC3A1Id());
  }

  /**
   * Method to retrieve a collection of all ExcDC3A1s
   *
   * @param query FindAllExcDC3A1Query
   * @return List<ExcDC3A1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcDC3A1> handle(FindAllExcDC3A1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcDC3A1, but only if the id matches
   *
   * @param entity ExcDC3A1
   */
  protected void emitFindExcDC3A1(ExcDC3A1 entity) {
    LOGGER.info("handling emitFindExcDC3A1");

    queryUpdateEmitter.emit(
        FindExcDC3A1Query.class,
        query -> query.getFilter().getExcDC3A1Id().equals(entity.getExcDC3A1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcDC3A1
   *
   * @param entity ExcDC3A1
   */
  protected void emitFindAllExcDC3A1(ExcDC3A1 entity) {
    LOGGER.info("handling emitFindAllExcDC3A1");

    queryUpdateEmitter.emit(FindAllExcDC3A1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcDC3A1Projector.class.getName());
}
