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
 * WindContRotorRIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindContRotorRIEC related services in the case of a
 *       WindContRotorRIEC business related service failing.
 *   <li>Exposes a simpler, uniform WindContRotorRIEC interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindContRotorRIEC business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindContRotorRIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindContRotorRIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindContRotorRIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindContRotorRIECBusinessDelegate
   */
  public static WindContRotorRIECBusinessDelegate getWindContRotorRIECInstance() {
    return (new WindContRotorRIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindContRotorRIEC(CreateWindContRotorRIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindContRotorRIECId() == null)
        command.setWindContRotorRIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindContRotorRIECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindContRotorRIECCommand of WindContRotorRIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindContRotorRIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindContRotorRIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindContRotorRIEC(UpdateWindContRotorRIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindContRotorRIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindContRotorRIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindContRotorRIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindContRotorRIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindContRotorRIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindContRotorRIEC using Id = " + command.getWindContRotorRIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindContRotorRIEC via WindContRotorRIECFetchOneSummary
   *
   * @param summary WindContRotorRIECFetchOneSummary
   * @return WindContRotorRIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindContRotorRIEC getWindContRotorRIEC(WindContRotorRIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindContRotorRIECFetchOneSummary arg cannot be null");

    WindContRotorRIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindContRotorRIEC
      // --------------------------------------
      CompletableFuture<WindContRotorRIEC> futureEntity =
          queryGateway.query(
              new FindWindContRotorRIECQuery(
                  new LoadWindContRotorRIECFilter(summary.getWindContRotorRIECId())),
              ResponseTypes.instanceOf(WindContRotorRIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindContRotorRIEC with id " + summary.getWindContRotorRIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindContRotorRIECs
   *
   * @return List<WindContRotorRIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindContRotorRIEC> getAllWindContRotorRIEC() throws ProcessingException {
    List<WindContRotorRIEC> list = null;

    try {
      CompletableFuture<List<WindContRotorRIEC>> futureList =
          queryGateway.query(
              new FindAllWindContRotorRIECQuery(),
              ResponseTypes.multipleInstancesOf(WindContRotorRIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindContRotorRIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Kirr on WindContRotorRIEC
   *
   * @param command AssignKirrToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignKirr(AssignKirrToWindContRotorRIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Kirr on WindContRotorRIEC
   *
   * @param command UnAssignKirrFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignKirr(UnAssignKirrFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kirr on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Komegafilt on WindContRotorRIEC
   *
   * @param command AssignKomegafiltToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignKomegafilt(AssignKomegafiltToWindContRotorRIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Komegafilt on WindContRotorRIEC
   *
   * @param command UnAssignKomegafiltFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignKomegafilt(UnAssignKomegafiltFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Komegafilt on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kpfilt on WindContRotorRIEC
   *
   * @param command AssignKpfiltToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignKpfilt(AssignKpfiltToWindContRotorRIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .Simple_FloatBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .Simple_FloatBusinessDelegate.getSimple_FloatInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getSimple_FloatId();
    Simple_Float child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Kpfilt on WindContRotorRIEC
   *
   * @param command UnAssignKpfiltFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignKpfilt(UnAssignKpfiltFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kpfilt on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Kprr on WindContRotorRIEC
   *
   * @param command AssignKprrToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignKprr(AssignKprrToWindContRotorRIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Kprr on WindContRotorRIEC
   *
   * @param command UnAssignKprrFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignKprr(UnAssignKprrFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Kprr on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rmax on WindContRotorRIEC
   *
   * @param command AssignRmaxToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignRmax(AssignRmaxToWindContRotorRIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Rmax on WindContRotorRIEC
   *
   * @param command UnAssignRmaxFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignRmax(UnAssignRmaxFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rmax on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Rmin on WindContRotorRIEC
   *
   * @param command AssignRminToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignRmin(AssignRminToWindContRotorRIECCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .PUBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .PUBusinessDelegate.getPUInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getPUId();
    PU child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Rmin on WindContRotorRIEC
   *
   * @param command UnAssignRminFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignRmin(UnAssignRminFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Rmin on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tomegafilt on WindContRotorRIEC
   *
   * @param command AssignTomegafiltToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignTomegafilt(AssignTomegafiltToWindContRotorRIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Tomegafilt on WindContRotorRIEC
   *
   * @param command UnAssignTomegafiltFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignTomegafilt(UnAssignTomegafiltFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tomegafilt on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Tpfilt on WindContRotorRIEC
   *
   * @param command AssignTpfiltToWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void assignTpfilt(AssignTpfiltToWindContRotorRIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindContRotorRIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .SecondsBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .SecondsBusinessDelegate.getSecondsInstance();
    WindContRotorRIECBusinessDelegate parentDelegate =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance();
    UUID childId = command.getAssignment().getSecondsId();
    Seconds child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

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
   * unAssign Tpfilt on WindContRotorRIEC
   *
   * @param command UnAssignTpfiltFromWindContRotorRIECCommand
   * @exception ProcessingException
   */
  public void unAssignTpfilt(UnAssignTpfiltFromWindContRotorRIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindContRotorRIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Tpfilt on WindContRotorRIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindContRotorRIEC
   */
  private WindContRotorRIEC load(UUID id) throws ProcessingException {
    windContRotorRIEC =
        WindContRotorRIECBusinessDelegate.getWindContRotorRIECInstance()
            .getWindContRotorRIEC(new WindContRotorRIECFetchOneSummary(id));
    return windContRotorRIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindContRotorRIEC windContRotorRIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindContRotorRIECBusinessDelegate.class.getName());
}
