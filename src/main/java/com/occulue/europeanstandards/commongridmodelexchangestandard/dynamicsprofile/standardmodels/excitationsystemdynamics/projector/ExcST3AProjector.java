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
 * Projector for ExcST3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST3A")
@Component("excST3A-projector")
public class ExcST3AProjector extends ExcST3AEntityProjector {

  // core constructor
  public ExcST3AProjector(ExcST3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST3AEvent
   */
  @EventHandler(payloadType = CreateExcST3AEvent.class)
  public void handle(CreateExcST3AEvent event) {
    LOGGER.info("handling CreateExcST3AEvent - " + event);
    ExcST3A entity = new ExcST3A();
    entity.setExcST3AId(event.getExcST3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UpdateExcST3AEvent
   */
  @EventHandler(payloadType = UpdateExcST3AEvent.class)
  public void handle(UpdateExcST3AEvent event) {
    LOGGER.info("handling UpdateExcST3AEvent - " + event);

    ExcST3A entity = new ExcST3A();
    entity.setExcST3AId(event.getExcST3AId());
    entity.setEfdmax(event.getEfdmax());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setKj(event.getKj());
    entity.setKm(event.getKm());
    entity.setKp(event.getKp());
    entity.setKs(event.getKs());
    entity.setKs1(event.getKs1());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setThetap(event.getThetap());
    entity.setTm(event.getTm());
    entity.setVbmax(event.getVbmax());
    entity.setVgmax(event.getVgmax());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setXl(event.getXl());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event DeleteExcST3AEvent
   */
  @EventHandler(payloadType = DeleteExcST3AEvent.class)
  public void handle(DeleteExcST3AEvent event) {
    LOGGER.info("handling DeleteExcST3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST3A entity = delete(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcST3AEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcST3AEvent.class)
  public void handle(AssignEfdmaxToExcST3AEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignEfdmax(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcST3AEvent.class)
  public void handle(UnAssignEfdmaxFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignEfdmax(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKcToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKcToExcST3AEvent.class)
  public void handle(AssignKcToExcST3AEvent event) {
    LOGGER.info("handling AssignKcToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKc(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcST3AEvent.class)
  public void handle(UnAssignKcFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKc(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKgToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKgToExcST3AEvent.class)
  public void handle(AssignKgToExcST3AEvent event) {
    LOGGER.info("handling AssignKgToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKg(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKgFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcST3AEvent.class)
  public void handle(UnAssignKgFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKgFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKg(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKiToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKiToExcST3AEvent.class)
  public void handle(AssignKiToExcST3AEvent event) {
    LOGGER.info("handling AssignKiToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKi(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKiFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcST3AEvent.class)
  public void handle(UnAssignKiFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKiFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKi(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKjToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKjToExcST3AEvent.class)
  public void handle(AssignKjToExcST3AEvent event) {
    LOGGER.info("handling AssignKjToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKj(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKjFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKjFromExcST3AEvent.class)
  public void handle(UnAssignKjFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKjFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKj(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKmToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKmToExcST3AEvent.class)
  public void handle(AssignKmToExcST3AEvent event) {
    LOGGER.info("handling AssignKmToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKm(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKmFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKmFromExcST3AEvent.class)
  public void handle(UnAssignKmFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKmFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKm(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKpToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKpToExcST3AEvent.class)
  public void handle(AssignKpToExcST3AEvent event) {
    LOGGER.info("handling AssignKpToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKp(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKpFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcST3AEvent.class)
  public void handle(UnAssignKpFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKpFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKp(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKsToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKsToExcST3AEvent.class)
  public void handle(AssignKsToExcST3AEvent event) {
    LOGGER.info("handling AssignKsToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKs(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcST3AEvent.class)
  public void handle(UnAssignKsFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKs(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignKs1ToExcST3AEvent
   */
  @EventHandler(payloadType = AssignKs1ToExcST3AEvent.class)
  public void handle(AssignKs1ToExcST3AEvent event) {
    LOGGER.info("handling AssignKs1ToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignKs1(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignKs1FromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignKs1FromExcST3AEvent.class)
  public void handle(UnAssignKs1FromExcST3AEvent event) {
    LOGGER.info("handling UnAssignKs1FromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignKs1(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignTbToExcST3AEvent
   */
  @EventHandler(payloadType = AssignTbToExcST3AEvent.class)
  public void handle(AssignTbToExcST3AEvent event) {
    LOGGER.info("handling AssignTbToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignTb(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcST3AEvent.class)
  public void handle(UnAssignTbFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignTb(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignTcToExcST3AEvent
   */
  @EventHandler(payloadType = AssignTcToExcST3AEvent.class)
  public void handle(AssignTcToExcST3AEvent event) {
    LOGGER.info("handling AssignTcToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignTc(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcST3AEvent.class)
  public void handle(UnAssignTcFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignTc(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignThetapToExcST3AEvent
   */
  @EventHandler(payloadType = AssignThetapToExcST3AEvent.class)
  public void handle(AssignThetapToExcST3AEvent event) {
    LOGGER.info("handling AssignThetapToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignThetap(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignThetapFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignThetapFromExcST3AEvent.class)
  public void handle(UnAssignThetapFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignThetapFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignThetap(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignTmToExcST3AEvent
   */
  @EventHandler(payloadType = AssignTmToExcST3AEvent.class)
  public void handle(AssignTmToExcST3AEvent event) {
    LOGGER.info("handling AssignTmToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignTm(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignTmFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignTmFromExcST3AEvent.class)
  public void handle(UnAssignTmFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignTmFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignTm(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignVbmaxToExcST3AEvent
   */
  @EventHandler(payloadType = AssignVbmaxToExcST3AEvent.class)
  public void handle(AssignVbmaxToExcST3AEvent event) {
    LOGGER.info("handling AssignVbmaxToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVbmax(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignVbmaxFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignVbmaxFromExcST3AEvent.class)
  public void handle(UnAssignVbmaxFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignVbmaxFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVbmax(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignVgmaxToExcST3AEvent
   */
  @EventHandler(payloadType = AssignVgmaxToExcST3AEvent.class)
  public void handle(AssignVgmaxToExcST3AEvent event) {
    LOGGER.info("handling AssignVgmaxToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVgmax(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignVgmaxFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignVgmaxFromExcST3AEvent.class)
  public void handle(UnAssignVgmaxFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignVgmaxFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVgmax(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignVimaxToExcST3AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcST3AEvent.class)
  public void handle(AssignVimaxToExcST3AEvent event) {
    LOGGER.info("handling AssignVimaxToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVimax(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcST3AEvent.class)
  public void handle(UnAssignVimaxFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVimax(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignViminToExcST3AEvent
   */
  @EventHandler(payloadType = AssignViminToExcST3AEvent.class)
  public void handle(AssignViminToExcST3AEvent event) {
    LOGGER.info("handling AssignViminToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVimin(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcST3AEvent.class)
  public void handle(UnAssignViminFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVimin(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST3AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST3AEvent.class)
  public void handle(AssignVrmaxToExcST3AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVrmax(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST3AEvent.class)
  public void handle(UnAssignVrmaxFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVrmax(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignVrminToExcST3AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST3AEvent.class)
  public void handle(AssignVrminToExcST3AEvent event) {
    LOGGER.info("handling AssignVrminToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignVrmin(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST3AEvent.class)
  public void handle(UnAssignVrminFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignVrmin(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event AssignXlToExcST3AEvent
   */
  @EventHandler(payloadType = AssignXlToExcST3AEvent.class)
  public void handle(AssignXlToExcST3AEvent event) {
    LOGGER.info("handling AssignXlToExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST3A entity = assignXl(event.getExcST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /*
   * @param	event UnAssignXlFromExcST3AEvent
   */
  @EventHandler(payloadType = UnAssignXlFromExcST3AEvent.class)
  public void handle(UnAssignXlFromExcST3AEvent event) {
    LOGGER.info("handling UnAssignXlFromExcST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST3A entity = unAssignXl(event.getExcST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST3A(entity);
  }

  /**
   * Method to retrieve the ExcST3A via an ExcST3APrimaryKey.
   *
   * @param id Long
   * @return ExcST3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST3A handle(FindExcST3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST3AId());
  }

  /**
   * Method to retrieve a collection of all ExcST3As
   *
   * @param query FindAllExcST3AQuery
   * @return List<ExcST3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST3A> handle(FindAllExcST3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST3A, but only if the id matches
   *
   * @param entity ExcST3A
   */
  protected void emitFindExcST3A(ExcST3A entity) {
    LOGGER.info("handling emitFindExcST3A");

    queryUpdateEmitter.emit(
        FindExcST3AQuery.class,
        query -> query.getFilter().getExcST3AId().equals(entity.getExcST3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST3A
   *
   * @param entity ExcST3A
   */
  protected void emitFindAllExcST3A(ExcST3A entity) {
    LOGGER.info("handling emitFindAllExcST3A");

    queryUpdateEmitter.emit(FindAllExcST3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST3AProjector.class.getName());
}
