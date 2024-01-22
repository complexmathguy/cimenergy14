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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindPlantReactiveControlIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindPlantReactiveControlIEC related services in the case of a
 *       WindPlantReactiveControlIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindPlantReactiveControlIEC interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       WindPlantReactiveControlIEC business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindPlantReactiveControlIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindPlantReactiveControlIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindPlantReactiveControlIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindPlantReactiveControlIECBusinessDelegate
   */
  public static WindPlantReactiveControlIECBusinessDelegate
      getWindPlantReactiveControlIECInstance() {
    return (new WindPlantReactiveControlIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindPlantReactiveControlIEC(
      CreateWindPlantReactiveControlIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindPlantReactiveControlIECId() == null)
        command.setWindPlantReactiveControlIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindPlantReactiveControlIECCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindPlantReactiveControlIECCommand of WindPlantReactiveControlIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindPlantReactiveControlIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindPlantReactiveControlIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindPlantReactiveControlIEC(
      UpdateWindPlantReactiveControlIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindPlantReactiveControlIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindPlantReactiveControlIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindPlantReactiveControlIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindPlantReactiveControlIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindPlantReactiveControlIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindPlantReactiveControlIEC using Id = "
              + command.getWindPlantReactiveControlIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindPlantReactiveControlIEC via
   * WindPlantReactiveControlIECFetchOneSummary
   *
   * @param summary WindPlantReactiveControlIECFetchOneSummary
   * @return WindPlantReactiveControlIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindPlantReactiveControlIEC getWindPlantReactiveControlIEC(
      WindPlantReactiveControlIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindPlantReactiveControlIECFetchOneSummary arg cannot be null");

    WindPlantReactiveControlIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindPlantReactiveControlIEC
      // --------------------------------------
      CompletableFuture<WindPlantReactiveControlIEC> futureEntity =
          queryGateway.query(
              new FindWindPlantReactiveControlIECQuery(
                  new LoadWindPlantReactiveControlIECFilter(
                      summary.getWindPlantReactiveControlIECId())),
              ResponseTypes.instanceOf(WindPlantReactiveControlIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindPlantReactiveControlIEC with id "
              + summary.getWindPlantReactiveControlIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindPlantReactiveControlIECs
   *
   * @return List<WindPlantReactiveControlIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindPlantReactiveControlIEC> getAllWindPlantReactiveControlIEC()
      throws ProcessingException {
    List<WindPlantReactiveControlIEC> list = null;

    try {
      CompletableFuture<List<WindPlantReactiveControlIEC>> futureList =
          queryGateway.query(
              new FindAllWindPlantReactiveControlIECQuery(),
              ResponseTypes.multipleInstancesOf(WindPlantReactiveControlIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kiwpx on WindPlantReactiveControlIEC
   *
   * @param command AssignKiwpxToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignKiwpx(AssignKiwpxToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

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
   * unAssign Kiwpx on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKiwpxFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignKiwpx(UnAssignKiwpxFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kiwpx on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpwpx on WindPlantReactiveControlIEC
   *
   * @param command AssignKpwpxToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignKpwpx(AssignKpwpxToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

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
   * unAssign Kpwpx on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKpwpxFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpwpx(UnAssignKpwpxFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpwpx on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kwpqu on WindPlantReactiveControlIEC
   *
   * @param command AssignKwpquToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignKwpqu(AssignKwpquToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Kwpqu on WindPlantReactiveControlIEC
   *
   * @param command UnAssignKwpquFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignKwpqu(UnAssignKwpquFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kwpqu on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwppf on WindPlantReactiveControlIEC
   *
   * @param command AssignMwppfToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignMwppf(AssignMwppfToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mwppf on WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwppfFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignMwppf(UnAssignMwppfFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwppf on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Mwpu on WindPlantReactiveControlIEC
   *
   * @param command AssignMwpuToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignMwpu(AssignMwpuToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Mwpu on WindPlantReactiveControlIEC
   *
   * @param command UnAssignMwpuFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignMwpu(UnAssignMwpuFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Mwpu on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twppfilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwppfiltToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignTwppfilt(AssignTwppfiltToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Twppfilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwppfiltFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwppfilt(UnAssignTwppfiltFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twppfilt on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twpqfilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwpqfiltToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignTwpqfilt(AssignTwpqfiltToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Twpqfilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwpqfilt(UnAssignTwpqfiltFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twpqfilt on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Twpufilt on WindPlantReactiveControlIEC
   *
   * @param command AssignTwpufiltToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignTwpufilt(AssignTwpufiltToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Twpufilt on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTwpufiltFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignTwpufilt(UnAssignTwpufiltFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Twpufilt on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Txft on WindPlantReactiveControlIEC
   *
   * @param command AssignTxftToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignTxft(AssignTxftToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Txft on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxftFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignTxft(UnAssignTxftFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Txft on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Txfv on WindPlantReactiveControlIEC
   *
   * @param command AssignTxfvToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignTxfv(AssignTxfvToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get Seconds using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Txfv on WindPlantReactiveControlIEC
   *
   * @param command UnAssignTxfvFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignTxfv(UnAssignTxfvFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Txfv on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Uwpqdip on WindPlantReactiveControlIEC
   *
   * @param command AssignUwpqdipToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignUwpqdip(AssignUwpqdipToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Uwpqdip on WindPlantReactiveControlIEC
   *
   * @param command UnAssignUwpqdipFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignUwpqdip(UnAssignUwpqdipFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Uwpqdip on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xrefmax on WindPlantReactiveControlIEC
   *
   * @param command AssignXrefmaxToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignXrefmax(AssignXrefmaxToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Xrefmax on WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefmaxFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignXrefmax(UnAssignXrefmaxFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xrefmax on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Xrefmin on WindPlantReactiveControlIEC
   *
   * @param command AssignXrefminToWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void assignXrefmin(AssignXrefminToWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantReactiveControlIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindPlantReactiveControlIECBusinessDelegate parentDelegate =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get PU using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Xrefmin on WindPlantReactiveControlIEC
   *
   * @param command UnAssignXrefminFromWindPlantReactiveControlIECCommand
   * @exception ProcessingException
   */
  public void unAssignXrefmin(UnAssignXrefminFromWindPlantReactiveControlIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantReactiveControlIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Xrefmin on WindPlantReactiveControlIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindPlantReactiveControlIEC
   */
  private WindPlantReactiveControlIEC load(UUID id) throws ProcessingException {
    windPlantReactiveControlIEC =
        WindPlantReactiveControlIECBusinessDelegate.getWindPlantReactiveControlIECInstance()
            .getWindPlantReactiveControlIEC(new WindPlantReactiveControlIECFetchOneSummary(id));
    return windPlantReactiveControlIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindPlantReactiveControlIEC windPlantReactiveControlIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantReactiveControlIECBusinessDelegate.class.getName());
}
