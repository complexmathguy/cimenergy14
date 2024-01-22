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
 * Projector for ExcST4B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST4B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST4BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST4B")
@Component("excST4B-projector")
public class ExcST4BProjector extends ExcST4BEntityProjector {

  // core constructor
  public ExcST4BProjector(ExcST4BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST4BEvent
   */
  @EventHandler(payloadType = CreateExcST4BEvent.class)
  public void handle(CreateExcST4BEvent event) {
    LOGGER.info("handling CreateExcST4BEvent - " + event);
    ExcST4B entity = new ExcST4B();
    entity.setExcST4BId(event.getExcST4BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UpdateExcST4BEvent
   */
  @EventHandler(payloadType = UpdateExcST4BEvent.class)
  public void handle(UpdateExcST4BEvent event) {
    LOGGER.info("handling UpdateExcST4BEvent - " + event);

    ExcST4B entity = new ExcST4B();
    entity.setExcST4BId(event.getExcST4BId());
    entity.setKc(event.getKc());
    entity.setKg(event.getKg());
    entity.setKi(event.getKi());
    entity.setKim(event.getKim());
    entity.setKir(event.getKir());
    entity.setKp(event.getKp());
    entity.setKpm(event.getKpm());
    entity.setKpr(event.getKpr());
    entity.setLvgate(event.getLvgate());
    entity.setTa(event.getTa());
    entity.setThetap(event.getThetap());
    entity.setUel(event.getUel());
    entity.setVbmax(event.getVbmax());
    entity.setVgmax(event.getVgmax());
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
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event DeleteExcST4BEvent
   */
  @EventHandler(payloadType = DeleteExcST4BEvent.class)
  public void handle(DeleteExcST4BEvent event) {
    LOGGER.info("handling DeleteExcST4BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST4B entity = delete(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKcToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKcToExcST4BEvent.class)
  public void handle(AssignKcToExcST4BEvent event) {
    LOGGER.info("handling AssignKcToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKc(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcST4BEvent.class)
  public void handle(UnAssignKcFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKc(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKgToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKgToExcST4BEvent.class)
  public void handle(AssignKgToExcST4BEvent event) {
    LOGGER.info("handling AssignKgToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKg(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKgFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKgFromExcST4BEvent.class)
  public void handle(UnAssignKgFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKgFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKg(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKiToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKiToExcST4BEvent.class)
  public void handle(AssignKiToExcST4BEvent event) {
    LOGGER.info("handling AssignKiToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKi(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKiFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcST4BEvent.class)
  public void handle(UnAssignKiFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKiFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKi(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKimToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKimToExcST4BEvent.class)
  public void handle(AssignKimToExcST4BEvent event) {
    LOGGER.info("handling AssignKimToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKim(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKimFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKimFromExcST4BEvent.class)
  public void handle(UnAssignKimFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKimFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKim(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKirToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKirToExcST4BEvent.class)
  public void handle(AssignKirToExcST4BEvent event) {
    LOGGER.info("handling AssignKirToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKir(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKirFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKirFromExcST4BEvent.class)
  public void handle(UnAssignKirFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKirFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKir(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKpToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKpToExcST4BEvent.class)
  public void handle(AssignKpToExcST4BEvent event) {
    LOGGER.info("handling AssignKpToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKp(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKpFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcST4BEvent.class)
  public void handle(UnAssignKpFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKpFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKp(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKpmToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKpmToExcST4BEvent.class)
  public void handle(AssignKpmToExcST4BEvent event) {
    LOGGER.info("handling AssignKpmToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKpm(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKpmFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKpmFromExcST4BEvent.class)
  public void handle(UnAssignKpmFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKpmFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKpm(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignKprToExcST4BEvent
   */
  @EventHandler(payloadType = AssignKprToExcST4BEvent.class)
  public void handle(AssignKprToExcST4BEvent event) {
    LOGGER.info("handling AssignKprToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignKpr(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignKprFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignKprFromExcST4BEvent.class)
  public void handle(UnAssignKprFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignKprFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignKpr(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignLvgateToExcST4BEvent
   */
  @EventHandler(payloadType = AssignLvgateToExcST4BEvent.class)
  public void handle(AssignLvgateToExcST4BEvent event) {
    LOGGER.info("handling AssignLvgateToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignLvgate(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignLvgateFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignLvgateFromExcST4BEvent.class)
  public void handle(UnAssignLvgateFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignLvgateFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignLvgate(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignTaToExcST4BEvent
   */
  @EventHandler(payloadType = AssignTaToExcST4BEvent.class)
  public void handle(AssignTaToExcST4BEvent event) {
    LOGGER.info("handling AssignTaToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignTa(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignTaFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcST4BEvent.class)
  public void handle(UnAssignTaFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignTaFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignTa(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignThetapToExcST4BEvent
   */
  @EventHandler(payloadType = AssignThetapToExcST4BEvent.class)
  public void handle(AssignThetapToExcST4BEvent event) {
    LOGGER.info("handling AssignThetapToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignThetap(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignThetapFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignThetapFromExcST4BEvent.class)
  public void handle(UnAssignThetapFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignThetapFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignThetap(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignUelToExcST4BEvent
   */
  @EventHandler(payloadType = AssignUelToExcST4BEvent.class)
  public void handle(AssignUelToExcST4BEvent event) {
    LOGGER.info("handling AssignUelToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignUel(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignUelFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignUelFromExcST4BEvent.class)
  public void handle(UnAssignUelFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignUelFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignUel(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVbmaxToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVbmaxToExcST4BEvent.class)
  public void handle(AssignVbmaxToExcST4BEvent event) {
    LOGGER.info("handling AssignVbmaxToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVbmax(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVbmaxFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVbmaxFromExcST4BEvent.class)
  public void handle(UnAssignVbmaxFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVbmaxFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVbmax(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVgmaxToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVgmaxToExcST4BEvent.class)
  public void handle(AssignVgmaxToExcST4BEvent event) {
    LOGGER.info("handling AssignVgmaxToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVgmax(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVgmaxFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVgmaxFromExcST4BEvent.class)
  public void handle(UnAssignVgmaxFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVgmaxFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVgmax(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVmmaxToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVmmaxToExcST4BEvent.class)
  public void handle(AssignVmmaxToExcST4BEvent event) {
    LOGGER.info("handling AssignVmmaxToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVmmax(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVmmaxFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVmmaxFromExcST4BEvent.class)
  public void handle(UnAssignVmmaxFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVmmaxFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVmmax(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVmminToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVmminToExcST4BEvent.class)
  public void handle(AssignVmminToExcST4BEvent event) {
    LOGGER.info("handling AssignVmminToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVmmin(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVmminFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVmminFromExcST4BEvent.class)
  public void handle(UnAssignVmminFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVmminFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVmmin(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST4BEvent.class)
  public void handle(AssignVrmaxToExcST4BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVrmax(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST4BEvent.class)
  public void handle(UnAssignVrmaxFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVrmax(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignVrminToExcST4BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST4BEvent.class)
  public void handle(AssignVrminToExcST4BEvent event) {
    LOGGER.info("handling AssignVrminToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignVrmin(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST4BEvent.class)
  public void handle(UnAssignVrminFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignVrmin(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event AssignXlToExcST4BEvent
   */
  @EventHandler(payloadType = AssignXlToExcST4BEvent.class)
  public void handle(AssignXlToExcST4BEvent event) {
    LOGGER.info("handling AssignXlToExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST4B entity = assignXl(event.getExcST4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /*
   * @param	event UnAssignXlFromExcST4BEvent
   */
  @EventHandler(payloadType = UnAssignXlFromExcST4BEvent.class)
  public void handle(UnAssignXlFromExcST4BEvent event) {
    LOGGER.info("handling UnAssignXlFromExcST4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST4B entity = unAssignXl(event.getExcST4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST4B(entity);
  }

  /**
   * Method to retrieve the ExcST4B via an ExcST4BPrimaryKey.
   *
   * @param id Long
   * @return ExcST4B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST4B handle(FindExcST4BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST4BId());
  }

  /**
   * Method to retrieve a collection of all ExcST4Bs
   *
   * @param query FindAllExcST4BQuery
   * @return List<ExcST4B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST4B> handle(FindAllExcST4BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST4B, but only if the id matches
   *
   * @param entity ExcST4B
   */
  protected void emitFindExcST4B(ExcST4B entity) {
    LOGGER.info("handling emitFindExcST4B");

    queryUpdateEmitter.emit(
        FindExcST4BQuery.class,
        query -> query.getFilter().getExcST4BId().equals(entity.getExcST4BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST4B
   *
   * @param entity ExcST4B
   */
  protected void emitFindAllExcST4B(ExcST4B entity) {
    LOGGER.info("handling emitFindAllExcST4B");

    queryUpdateEmitter.emit(FindAllExcST4BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST4BProjector.class.getName());
}
