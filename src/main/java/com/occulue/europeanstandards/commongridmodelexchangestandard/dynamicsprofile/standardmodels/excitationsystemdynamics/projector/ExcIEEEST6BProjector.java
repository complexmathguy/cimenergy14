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
 * Projector for ExcIEEEST6B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST6B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST6BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST6B")
@Component("excIEEEST6B-projector")
public class ExcIEEEST6BProjector extends ExcIEEEST6BEntityProjector {

  // core constructor
  public ExcIEEEST6BProjector(
      ExcIEEEST6BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST6BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST6BEvent.class)
  public void handle(CreateExcIEEEST6BEvent event) {
    LOGGER.info("handling CreateExcIEEEST6BEvent - " + event);
    ExcIEEEST6B entity = new ExcIEEEST6B();
    entity.setExcIEEEST6BId(event.getExcIEEEST6BId());
    entity.setOelin(event.getOelin());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UpdateExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST6BEvent.class)
  public void handle(UpdateExcIEEEST6BEvent event) {
    LOGGER.info("handling UpdateExcIEEEST6BEvent - " + event);

    ExcIEEEST6B entity = new ExcIEEEST6B();
    entity.setExcIEEEST6BId(event.getExcIEEEST6BId());
    entity.setIlr(event.getIlr());
    entity.setKci(event.getKci());
    entity.setKff(event.getKff());
    entity.setKg(event.getKg());
    entity.setKia(event.getKia());
    entity.setKlr(event.getKlr());
    entity.setKm(event.getKm());
    entity.setKpa(event.getKpa());
    entity.setOelin(event.getOelin());
    entity.setTg(event.getTg());
    entity.setVamax(event.getVamax());
    entity.setVamin(event.getVamin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event DeleteExcIEEEST6BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST6BEvent.class)
  public void handle(DeleteExcIEEEST6BEvent event) {
    LOGGER.info("handling DeleteExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST6B entity = delete(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignIlrToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignIlrToExcIEEEST6BEvent.class)
  public void handle(AssignIlrToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignIlrToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignIlr(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignIlrFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignIlrFromExcIEEEST6BEvent.class)
  public void handle(UnAssignIlrFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignIlrFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignIlr(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKciToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKciToExcIEEEST6BEvent.class)
  public void handle(AssignKciToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKciToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKci(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKciFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKciFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKciFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKciFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKci(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKffToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKffToExcIEEEST6BEvent.class)
  public void handle(AssignKffToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKffToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKff(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKffFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKffFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKffFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKffFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKff(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKgToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKgToExcIEEEST6BEvent.class)
  public void handle(AssignKgToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKgToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKg(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKgFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKgFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKgFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKg(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKiaToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKiaToExcIEEEST6BEvent.class)
  public void handle(AssignKiaToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKiaToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKia(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKiaFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKiaFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKiaFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKiaFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKia(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKlrToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKlrToExcIEEEST6BEvent.class)
  public void handle(AssignKlrToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKlrToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKlr(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKlrFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKlrFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKlrFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKlrFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKlr(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKmToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKmToExcIEEEST6BEvent.class)
  public void handle(AssignKmToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKmToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKm(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKmFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKmFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKmFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKmFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKm(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignKpaToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignKpaToExcIEEEST6BEvent.class)
  public void handle(AssignKpaToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignKpaToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignKpa(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignKpaFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignKpaFromExcIEEEST6BEvent.class)
  public void handle(UnAssignKpaFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignKpaFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignKpa(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignTgToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignTgToExcIEEEST6BEvent.class)
  public void handle(AssignTgToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignTgToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignTg(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignTgFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignTgFromExcIEEEST6BEvent.class)
  public void handle(UnAssignTgFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignTgFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignTg(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignVamaxToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignVamaxToExcIEEEST6BEvent.class)
  public void handle(AssignVamaxToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignVamaxToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignVamax(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignVamaxFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignVamaxFromExcIEEEST6BEvent.class)
  public void handle(UnAssignVamaxFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignVamaxFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignVamax(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignVaminToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignVaminToExcIEEEST6BEvent.class)
  public void handle(AssignVaminToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignVaminToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignVamin(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignVaminFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignVaminFromExcIEEEST6BEvent.class)
  public void handle(UnAssignVaminFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignVaminFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignVamin(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST6BEvent.class)
  public void handle(AssignVrmaxToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignVrmax(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST6BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignVrmax(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST6BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST6BEvent.class)
  public void handle(AssignVrminToExcIEEEST6BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST6B entity = assignVrmin(event.getExcIEEEST6BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST6BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST6BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST6BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST6BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST6B entity = unAssignVrmin(event.getExcIEEEST6BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST6B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST6B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST6B via an ExcIEEEST6BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST6B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST6B handle(FindExcIEEEST6BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST6BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST6Bs
   *
   * @param query FindAllExcIEEEST6BQuery
   * @return List<ExcIEEEST6B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST6B> handle(FindAllExcIEEEST6BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST6B, but only if the id matches
   *
   * @param entity ExcIEEEST6B
   */
  protected void emitFindExcIEEEST6B(ExcIEEEST6B entity) {
    LOGGER.info("handling emitFindExcIEEEST6B");

    queryUpdateEmitter.emit(
        FindExcIEEEST6BQuery.class,
        query -> query.getFilter().getExcIEEEST6BId().equals(entity.getExcIEEEST6BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST6B
   *
   * @param entity ExcIEEEST6B
   */
  protected void emitFindAllExcIEEEST6B(ExcIEEEST6B entity) {
    LOGGER.info("handling emitFindAllExcIEEEST6B");

    queryUpdateEmitter.emit(FindAllExcIEEEST6BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST6BProjector.class.getName());
}
