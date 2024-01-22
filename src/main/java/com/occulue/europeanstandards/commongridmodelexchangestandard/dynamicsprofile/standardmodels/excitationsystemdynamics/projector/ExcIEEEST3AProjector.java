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
 * Projector for ExcIEEEST3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST3A")
@Component("excIEEEST3A-projector")
public class ExcIEEEST3AProjector extends ExcIEEEST3AEntityProjector {

  // core constructor
  public ExcIEEEST3AProjector(
      ExcIEEEST3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST3AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST3AEvent.class)
  public void handle(CreateExcIEEEST3AEvent event) {
    LOGGER.info("handling CreateExcIEEEST3AEvent - " + event);
    ExcIEEEST3A entity = new ExcIEEEST3A();
    entity.setExcIEEEST3AId(event.getExcIEEEST3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UpdateExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST3AEvent.class)
  public void handle(UpdateExcIEEEST3AEvent event) {
    LOGGER.info("handling UpdateExcIEEEST3AEvent - " + event);

    ExcIEEEST3A entity = new ExcIEEEST3A();
    entity.setExcIEEEST3AId(event.getExcIEEEST3AId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setKm(event.getKm());
    entity.setKp(event.getKp());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setThetap(event.getThetap());
    entity.setTm(event.getTm());
    entity.setVbmax(event.getVbmax());
    entity.setVgmax(event.getVgmax());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVmmax(event.getVmmax());
    entity.setVmmin(event.getVmmin());
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
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event DeleteExcIEEEST3AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST3AEvent.class)
  public void handle(DeleteExcIEEEST3AEvent event) {
    LOGGER.info("handling DeleteExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST3A entity = delete(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEST3AEvent.class)
  public void handle(AssignKaToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKa(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKaFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKa(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEST3AEvent.class)
  public void handle(AssignKcToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKc(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKcFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKc(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKgToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKgToExcIEEEST3AEvent.class)
  public void handle(AssignKgToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKgToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKg(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKgFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKgFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKgFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKg(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKiToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKiToExcIEEEST3AEvent.class)
  public void handle(AssignKiToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKiToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKi(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKiFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKiFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKiFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKi(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKmToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKmToExcIEEEST3AEvent.class)
  public void handle(AssignKmToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKmToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKm(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKmFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKmFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKmFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKmFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKm(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignKpToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignKpToExcIEEEST3AEvent.class)
  public void handle(AssignKpToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignKpToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignKp(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignKpFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcIEEEST3AEvent.class)
  public void handle(UnAssignKpFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignKpFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignKp(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEST3AEvent.class)
  public void handle(AssignTaToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignTa(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEST3AEvent.class)
  public void handle(UnAssignTaFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignTa(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEST3AEvent.class)
  public void handle(AssignTbToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignTb(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEST3AEvent.class)
  public void handle(UnAssignTbFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignTb(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEST3AEvent.class)
  public void handle(AssignTcToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignTc(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEST3AEvent.class)
  public void handle(UnAssignTcFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignTc(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignThetapToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignThetapToExcIEEEST3AEvent.class)
  public void handle(AssignThetapToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignThetapToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignThetap(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignThetapFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignThetapFromExcIEEEST3AEvent.class)
  public void handle(UnAssignThetapFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignThetapFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignThetap(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignTmToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignTmToExcIEEEST3AEvent.class)
  public void handle(AssignTmToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignTmToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignTm(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignTmFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignTmFromExcIEEEST3AEvent.class)
  public void handle(UnAssignTmFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignTmFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignTm(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVbmaxToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVbmaxToExcIEEEST3AEvent.class)
  public void handle(AssignVbmaxToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVbmaxToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVbmax(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVbmaxFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVbmaxFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVbmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVbmaxFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVbmax(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVgmaxToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVgmaxToExcIEEEST3AEvent.class)
  public void handle(AssignVgmaxToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVgmaxToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVgmax(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVgmaxFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVgmaxFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVgmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVgmaxFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVgmax(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVimaxToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcIEEEST3AEvent.class)
  public void handle(AssignVimaxToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVimaxToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVimax(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVimaxFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVimax(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignViminToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignViminToExcIEEEST3AEvent.class)
  public void handle(AssignViminToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignViminToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVimin(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcIEEEST3AEvent.class)
  public void handle(UnAssignViminFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVimin(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVmmaxToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVmmaxToExcIEEEST3AEvent.class)
  public void handle(AssignVmmaxToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVmmaxToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVmmax(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVmmaxFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVmmaxFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVmmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVmmaxFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVmmax(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVmminToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVmminToExcIEEEST3AEvent.class)
  public void handle(AssignVmminToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVmminToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVmmin(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVmminFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVmminFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVmminFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVmminFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVmmin(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST3AEvent.class)
  public void handle(AssignVrmaxToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVrmax(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVrmax(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST3AEvent.class)
  public void handle(AssignVrminToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignVrmin(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST3AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignVrmin(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event AssignXlToExcIEEEST3AEvent
   */
  @EventHandler(payloadType = AssignXlToExcIEEEST3AEvent.class)
  public void handle(AssignXlToExcIEEEST3AEvent event) {
    LOGGER.info("handling AssignXlToExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST3A entity = assignXl(event.getExcIEEEST3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /*
   * @param	event UnAssignXlFromExcIEEEST3AEvent
   */
  @EventHandler(payloadType = UnAssignXlFromExcIEEEST3AEvent.class)
  public void handle(UnAssignXlFromExcIEEEST3AEvent event) {
    LOGGER.info("handling UnAssignXlFromExcIEEEST3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST3A entity = unAssignXl(event.getExcIEEEST3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST3A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST3A via an ExcIEEEST3APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST3A handle(FindExcIEEEST3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST3AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST3As
   *
   * @param query FindAllExcIEEEST3AQuery
   * @return List<ExcIEEEST3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST3A> handle(FindAllExcIEEEST3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST3A, but only if the id matches
   *
   * @param entity ExcIEEEST3A
   */
  protected void emitFindExcIEEEST3A(ExcIEEEST3A entity) {
    LOGGER.info("handling emitFindExcIEEEST3A");

    queryUpdateEmitter.emit(
        FindExcIEEEST3AQuery.class,
        query -> query.getFilter().getExcIEEEST3AId().equals(entity.getExcIEEEST3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST3A
   *
   * @param entity ExcIEEEST3A
   */
  protected void emitFindAllExcIEEEST3A(ExcIEEEST3A entity) {
    LOGGER.info("handling emitFindAllExcIEEEST3A");

    queryUpdateEmitter.emit(FindAllExcIEEEST3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST3AProjector.class.getName());
}
