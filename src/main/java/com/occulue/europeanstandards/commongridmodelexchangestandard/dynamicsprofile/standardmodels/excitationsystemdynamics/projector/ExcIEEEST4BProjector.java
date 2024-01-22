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
 * Projector for ExcIEEEST4B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST4B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST4BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST4B")
@Component("excIEEEST4B-projector")
public class ExcIEEEST4BProjector extends ExcIEEEST4BEntityProjector {

  // core constructor
  public ExcIEEEST4BProjector(
      ExcIEEEST4BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST4BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST4BEvent.class)
  public void handle(CreateExcIEEEST4BEvent event) {
    LOGGER.info("handling CreateExcIEEEST4BEvent - " + event);
    ExcIEEEST4B entity = new ExcIEEEST4B();
    entity.setExcIEEEST4BId(event.getExcIEEEST4BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UpdateExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST4BEvent.class)
  public void handle(UpdateExcIEEEST4BEvent event) {
    LOGGER.info("handling UpdateExcIEEEST4BEvent - " + event);

    ExcIEEEST4B entity = new ExcIEEEST4B();
    entity.setExcIEEEST4BId(event.getExcIEEEST4BId());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setKim(event.getKim());
    entity.setKir(event.getKir());
    entity.setKp(event.getKp());
    entity.setKpm(event.getKpm());
    entity.setKpr(event.getKpr());
    entity.setTa(event.getTa());
    entity.setThetap(event.getThetap());
    entity.setVbmax(event.getVbmax());
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
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event DeleteExcIEEEST4BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST4BEvent.class)
  public void handle(DeleteExcIEEEST4BEvent event) {
    LOGGER.info("handling DeleteExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST4B entity = delete(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEST4BEvent.class)
  public void handle(AssignKcToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKc(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKcFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKc(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKgToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKgToExcIEEEST4BEvent.class)
  public void handle(AssignKgToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKgToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKg(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKgFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKgFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKgFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKg(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKiToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKiToExcIEEEST4BEvent.class)
  public void handle(AssignKiToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKiToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKi(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKiFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKiFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKiFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKi(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKimToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKimToExcIEEEST4BEvent.class)
  public void handle(AssignKimToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKimToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKim(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKimFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKimFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKimFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKimFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKim(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKirToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKirToExcIEEEST4BEvent.class)
  public void handle(AssignKirToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKirToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKir(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKirFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKirFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKirFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKirFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKir(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKpToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKpToExcIEEEST4BEvent.class)
  public void handle(AssignKpToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKpToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKp(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKpFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKpFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKpFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKp(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKpmToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKpmToExcIEEEST4BEvent.class)
  public void handle(AssignKpmToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKpmToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKpm(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKpmFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKpmFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKpmFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKpmFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKpm(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignKprToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignKprToExcIEEEST4BEvent.class)
  public void handle(AssignKprToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignKprToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignKpr(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignKprFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignKprFromExcIEEEST4BEvent.class)
  public void handle(UnAssignKprFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignKprFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignKpr(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEST4BEvent.class)
  public void handle(AssignTaToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignTa(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEST4BEvent.class)
  public void handle(UnAssignTaFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignTa(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignThetapToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignThetapToExcIEEEST4BEvent.class)
  public void handle(AssignThetapToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignThetapToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignThetap(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignThetapFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignThetapFromExcIEEEST4BEvent.class)
  public void handle(UnAssignThetapFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignThetapFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignThetap(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignVbmaxToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignVbmaxToExcIEEEST4BEvent.class)
  public void handle(AssignVbmaxToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignVbmaxToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignVbmax(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignVbmaxFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignVbmaxFromExcIEEEST4BEvent.class)
  public void handle(UnAssignVbmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignVbmaxFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignVbmax(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignVmmaxToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignVmmaxToExcIEEEST4BEvent.class)
  public void handle(AssignVmmaxToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignVmmaxToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignVmmax(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignVmmaxFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignVmmaxFromExcIEEEST4BEvent.class)
  public void handle(UnAssignVmmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignVmmaxFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignVmmax(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignVmminToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignVmminToExcIEEEST4BEvent.class)
  public void handle(AssignVmminToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignVmminToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignVmmin(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignVmminFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignVmminFromExcIEEEST4BEvent.class)
  public void handle(UnAssignVmminFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignVmminFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignVmmin(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST4BEvent.class)
  public void handle(AssignVrmaxToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignVrmax(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST4BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignVrmax(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST4BEvent.class)
  public void handle(AssignVrminToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignVrmin(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST4BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignVrmin(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event AssignXlToExcIEEEST4BEvent
   */
  @EventHandler(payloadType = AssignXlToExcIEEEST4BEvent.class)
  public void handle(AssignXlToExcIEEEST4BEvent event) {
    LOGGER.info("handling AssignXlToExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST4B entity = assignXl(event.getExcIEEEST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /*
   * @param	event UnAssignXlFromExcIEEEST4BEvent
   */
  @EventHandler(payloadType = UnAssignXlFromExcIEEEST4BEvent.class)
  public void handle(UnAssignXlFromExcIEEEST4BEvent event) {
    LOGGER.info("handling UnAssignXlFromExcIEEEST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST4B entity = unAssignXl(event.getExcIEEEST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST4B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST4B via an ExcIEEEST4BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST4B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST4B handle(FindExcIEEEST4BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST4BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST4Bs
   *
   * @param query FindAllExcIEEEST4BQuery
   * @return List<ExcIEEEST4B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST4B> handle(FindAllExcIEEEST4BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST4B, but only if the id matches
   *
   * @param entity ExcIEEEST4B
   */
  protected void emitFindExcIEEEST4B(ExcIEEEST4B entity) {
    LOGGER.info("handling emitFindExcIEEEST4B");

    queryUpdateEmitter.emit(
        FindExcIEEEST4BQuery.class,
        query -> query.getFilter().getExcIEEEST4BId().equals(entity.getExcIEEEST4BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST4B
   *
   * @param entity ExcIEEEST4B
   */
  protected void emitFindAllExcIEEEST4B(ExcIEEEST4B entity) {
    LOGGER.info("handling emitFindAllExcIEEEST4B");

    queryUpdateEmitter.emit(FindAllExcIEEEST4BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST4BProjector.class.getName());
}
