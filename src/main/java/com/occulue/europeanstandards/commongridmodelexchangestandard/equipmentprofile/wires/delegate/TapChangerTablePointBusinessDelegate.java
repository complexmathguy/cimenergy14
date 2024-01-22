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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * TapChangerTablePoint business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TapChangerTablePoint related services in the case of a
 *       TapChangerTablePoint business related service failing.
 *   <li>Exposes a simpler, uniform TapChangerTablePoint interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TapChangerTablePoint
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TapChangerTablePointBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TapChangerTablePointBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TapChangerTablePoint Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TapChangerTablePointBusinessDelegate
   */
  public static TapChangerTablePointBusinessDelegate getTapChangerTablePointInstance() {
    return (new TapChangerTablePointBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTapChangerTablePoint(
      CreateTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTapChangerTablePointId() == null)
        command.setTapChangerTablePointId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTapChangerTablePointCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTapChangerTablePointCommand of TapChangerTablePoint is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TapChangerTablePoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTapChangerTablePointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTapChangerTablePoint(
      UpdateTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTapChangerTablePointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TapChangerTablePoint - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTapChangerTablePointCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTapChangerTablePointCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTapChangerTablePointCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TapChangerTablePoint using Id = " + command.getTapChangerTablePointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TapChangerTablePoint via TapChangerTablePointFetchOneSummary
   *
   * @param summary TapChangerTablePointFetchOneSummary
   * @return TapChangerTablePointFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TapChangerTablePoint getTapChangerTablePoint(TapChangerTablePointFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("TapChangerTablePointFetchOneSummary arg cannot be null");

    TapChangerTablePoint entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TapChangerTablePoint
      // --------------------------------------
      CompletableFuture<TapChangerTablePoint> futureEntity =
          queryGateway.query(
              new FindTapChangerTablePointQuery(
                  new LoadTapChangerTablePointFilter(summary.getTapChangerTablePointId())),
              ResponseTypes.instanceOf(TapChangerTablePoint.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TapChangerTablePoint with id " + summary.getTapChangerTablePointId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TapChangerTablePoints
   *
   * @return List<TapChangerTablePoint>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TapChangerTablePoint> getAllTapChangerTablePoint() throws ProcessingException {
    List<TapChangerTablePoint> list = null;

    try {
      CompletableFuture<List<TapChangerTablePoint>> futureList =
          queryGateway.query(
              new FindAllTapChangerTablePointQuery(),
              ResponseTypes.multipleInstancesOf(TapChangerTablePoint.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TapChangerTablePoint";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign B on TapChangerTablePoint
   *
   * @param command AssignBToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignB(AssignBToTapChangerTablePointCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign B on TapChangerTablePoint
   *
   * @param command UnAssignBFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignB(UnAssignBFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign B on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign G on TapChangerTablePoint
   *
   * @param command AssignGToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignG(AssignGToTapChangerTablePointCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign G on TapChangerTablePoint
   *
   * @param command UnAssignGFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignG(UnAssignGFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign G on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign R on TapChangerTablePoint
   *
   * @param command AssignRToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignR(AssignRToTapChangerTablePointCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign R on TapChangerTablePoint
   *
   * @param command UnAssignRFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignR(UnAssignRFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign R on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Ratio on TapChangerTablePoint
   *
   * @param command AssignRatioToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignRatio(AssignRatioToTapChangerTablePointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Simple_Float using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Ratio on TapChangerTablePoint
   *
   * @param command UnAssignRatioFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignRatio(UnAssignRatioFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Ratio on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Step on TapChangerTablePoint
   *
   * @param command AssignStepToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignStep(AssignStepToTapChangerTablePointCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .IntegerProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .IntegerProxyBusinessDelegate.getIntegerProxyInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getIntegerProxyId();
    IntegerProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get IntegerProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Step on TapChangerTablePoint
   *
   * @param command UnAssignStepFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignStep(UnAssignStepFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Step on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign X on TapChangerTablePoint
   *
   * @param command AssignXToTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void assignX(AssignXToTapChangerTablePointCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTapChangerTablePointId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PerCentBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PerCentBusinessDelegate.getPerCentInstance();
    TapChangerTablePointBusinessDelegate parentDelegate =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance();
    UUID childId = command.getAssignment().getPerCentId();
    PerCent child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PerCent using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign X on TapChangerTablePoint
   *
   * @param command UnAssignXFromTapChangerTablePointCommand
   * @exception ProcessingException
   */
  public void unAssignX(UnAssignXFromTapChangerTablePointCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TapChangerTablePointValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign X on TapChangerTablePoint";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TapChangerTablePoint
   */
  private TapChangerTablePoint load(UUID id) throws ProcessingException {
    tapChangerTablePoint =
        TapChangerTablePointBusinessDelegate.getTapChangerTablePointInstance()
            .getTapChangerTablePoint(new TapChangerTablePointFetchOneSummary(id));
    return tapChangerTablePoint;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TapChangerTablePoint tapChangerTablePoint = null;
  private static final Logger LOGGER =
      Logger.getLogger(TapChangerTablePointBusinessDelegate.class.getName());
}
